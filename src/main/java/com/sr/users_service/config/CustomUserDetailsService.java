package com.sr.users_service.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sr.users_service.entity.Users;
import com.sr.users_service.repository.UsersRepository;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> credential = userRepo.findByUsername(username);
        System.out.println(credential);
        return credential.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("user not found with name: " + username));
    }
}