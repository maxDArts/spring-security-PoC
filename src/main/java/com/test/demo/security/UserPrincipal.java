package com.test.demo.security;

import com.test.demo.entety.Permission;
import com.test.demo.entety.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Getter
@Setter
public class UserPrincipal implements UserDetails {
    private User user;
    private List<Permission> permissions;

    private Set<String> networks;
    private Set<String> organizations;

    public UserPrincipal(User user, List<Permission> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    @Override
    public String getPassword() {
        return user.getPass();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions
                .stream()
                .map(p -> new SimpleGrantedAuthority(p.toStringPattern()))
                .collect(toList());
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
