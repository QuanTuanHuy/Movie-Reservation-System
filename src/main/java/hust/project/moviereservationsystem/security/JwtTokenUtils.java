package hust.project.moviereservationsystem.security;

import hust.project.moviereservationsystem.entity.UserEntity;
import hust.project.moviereservationsystem.exception.UnExpectedException;
import hust.project.moviereservationsystem.port.IRolePort;
import hust.project.moviereservationsystem.property.JwtProperty;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtTokenUtils {

    private final JwtProperty jwtProperty;
    private final IRolePort rolePort;

    public String generateToken(UserEntity user) {
        Map<String, String> claims = new HashMap<>();

        var role = rolePort.getRoleById(user.getRoleId());

        claims.put("email", user.getEmail());
        claims.put("user_id", String.valueOf(user.getId()));
        claims.put("role", "ROLE_" + role.getCode());

        try {
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(user.getEmail())
                    .setExpiration(
                            new Date(System.currentTimeMillis() + jwtProperty.getExpiration() * 1000L))
                    .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                    .compact();
        } catch (Exception e) {
            log.error("Error when generate token" + e.getMessage());
            throw new UnExpectedException();
        }
    }

    private Key getSigninKey() {
        var bytes = Decoders.BASE64.decode(jwtProperty.getSecret());
        return Keys.hmacShaKeyFor(bytes);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigninKey()).build().parseClaimsJws(token)
                .getBody();
    }

    private <T> T extractClaim(String token, Function<Claims, T> resolver) {
        final var claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    private Boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractUserId(String token) {
        return extractClaim(token, claims -> claims.get("user_id", String.class));
    }

    public boolean validateToken(String token, UserDetails user) {
        final var userId = extractUserId(token);
        return (userId.equals(user.getUsername()) && !isTokenExpired(token));
    }
}