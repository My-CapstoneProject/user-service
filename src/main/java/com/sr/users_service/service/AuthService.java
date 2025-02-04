package com.sr.users_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sr.users_service.entity.Users;
import com.sr.users_service.exception.UserExistException;
import com.sr.users_service.repository.UsersRepository;

@Service
public class AuthService {
	
	@Autowired
    private UsersRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

 

    public Users saveUser(Users user){
        user.setPassword((passwordEncoder.encode(user.getPassword())));
        try {
            return userRepo.save(user);
        }
        catch (Exception e){
            throw new UserExistException("User already");
        }
    }
    public String generateToken(String username)
    {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
    public boolean isUserRegistered(String username) {
        // Check if a user with the given username already exists in the database
        return userRepo.existsByUsername(username);
    }

    public Users findByUsername(String username) {
        Optional<Users> personOptional = userRepo.findByUsername(username);
        // If the user exists, return the Person object, otherwise return null
        return personOptional.orElse(null); // Return null if user is not found
    }

    public List<Users> findUsersWaitingForApproval() {
        return userRepo.findByStatus(0); // 0 represents waiting for approval
    }
    
    public void ValidateAdmin(Users user){


    }
}
