package hust.project.moviereservationsystem.security;

import hust.project.moviereservationsystem.exception.UnExpectedException;
import hust.project.moviereservationsystem.property.RequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {
    private final RequestFilter requestFilter;

    private final UserDetailsService userDetailsService;

    private final JwtTokenUtils jwtTokenUtils;


    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) {
        try {
            if (isByPassToken(request)) {
                filterChain.doFilter(request, response);
                return;
            }

            final String authenticationHeader = request.getHeader("Authorization");
            if (authenticationHeader != null && authenticationHeader.startsWith("Bearer ")) {
                final var token = authenticationHeader.substring(7);
                final var email = jwtTokenUtils.extractEmail(token);

                if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    var currentUser = (CustomUserDetails) userDetailsService.loadUserByUsername(email);

                    if (jwtTokenUtils.validateToken(token, currentUser)) {
                        var authentication = new UsernamePasswordAuthenticationToken(
                                currentUser, null, currentUser.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
                filterChain.doFilter(request, response);
                return;
            }
            throw new UnExpectedException();
        } catch (Exception e) {
            log.error("[JwtTokenFilter] token filter error: {}", e.getMessage());
        }
    }

    private boolean isByPassToken(HttpServletRequest request) {
        var byPassTokens = requestFilter.getPublicUrls();

        for (var byPassToken : byPassTokens) {
            log.info("[JwtTokenFilter] byPassToken: {}", byPassToken);
            if (request.getRequestURI().matches(byPassToken.getFirst())
                    && request.getMethod().equalsIgnoreCase(byPassToken.getSecond())) {
                return true;
            }
        }

        return false;
    }
}
