package com.harishraj.springsecuritydemo.service;

import com.harishraj.springsecuritydemo.model.User;
import com.harishraj.springsecuritydemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public ResponseEntity<?> registerUser(User user) {
        // Check if user already exists
        if (userRepo.existsByUsername(user.getUsername())) { // Assuming you have this method in your repository
            return ResponseEntity.badRequest().body("Username already taken.");
        }

        // Encode the password before saving
        user.setPassword(encoder.encode(user.getPassword()));

        // Save the user and return a response
        User savedUser = userRepo.save(user);
        return ResponseEntity.ok(savedUser); // or return a success message instead
    }

    public String verify(User user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(user.getUsername());
            }
        } catch (BadCredentialsException e) {
            // Log or handle the exception
            return null; // Indicate that authentication failed
        }
        return null; // If authentication wasn't successful
    }


}
