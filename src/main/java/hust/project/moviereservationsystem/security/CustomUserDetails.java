package hust.project.moviereservationsystem.security;

import hust.project.moviereservationsystem.entity.UserEntity;
import hust.project.moviereservationsystem.port.IRolePort;
import hust.project.moviereservationsystem.port.IUserPort;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@Slf4j
public class CustomUserDetails implements UserDetails {
    private final UserEntity userEntity;
    private final IUserPort userPort;
    private final IRolePort rolePort;

    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(UserEntity userEntity, IUserPort userPort, IRolePort rolePort) {
        this.userEntity = userEntity;
        this.userPort = userPort;
        this.rolePort = rolePort;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var role = rolePort.getRoleById(userEntity.getRoleId());
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + role.getCode()));
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return String.valueOf(userEntity.getId());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
