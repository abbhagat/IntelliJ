package org.spring.boot.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetail implements UserDetails {

    private int id;
    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    public UserDetail() {

    }

    public UserDetail(User user) {
        this.id          = user.getId();
        this.userName    = user.getUserName();
        this.password    = user.getPassword();
        this.active      = user.isActive();
        this.authorities = Arrays.stream(user.getRoles().split(","))
                                                        .map(SimpleGrantedAuthority::new)
                                                        .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
        return active;
    }
}
