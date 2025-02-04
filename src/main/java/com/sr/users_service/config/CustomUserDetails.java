package com.sr.users_service.config;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sr.users_service.entity.Users;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private int id;
    private String username;
    private String password;
    private String role;

    public CustomUserDetails(Users userCredential) {
        this.id = userCredential.getId();
        this.username = userCredential.getUsername();
        this.password = userCredential.getPassword();
        this.role = userCredential.getRole();  // Get the role of the user
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convert role to authorities
        return List.of(() -> role);  // This is how we can assign role as authority
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    // Getter for id
    public int getId() {
        return id;
    }
}
