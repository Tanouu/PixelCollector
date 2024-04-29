package com.ethan.ai115.pixelcollector.controller;

import com.ethan.ai115.pixelcollector.dto.LoginDto;
import com.ethan.ai115.pixelcollector.dto.UserDto;
import com.ethan.ai115.pixelcollector.model.User;
import com.ethan.ai115.pixelcollector.security.JwtGenerator;
import com.ethan.ai115.pixelcollector.service.impl.TwoFactorAuthenticationServiceImpl;
import com.ethan.ai115.pixelcollector.service.impl.UserDetailsServiceImpl;
import com.ethan.ai115.pixelcollector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtGenerator jwtGenerator;

    @Autowired
    private TwoFactorAuthenticationServiceImpl twoFactorAuthService;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder, UserDetailsServiceImpl userDetailsService, JwtGenerator jwtUtil) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.jwtGenerator = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginData) {
        User user = userService.findUserByUsername(loginData.getUsername());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        } else if (!passwordEncoder.matches(loginData.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username/password");
        }

        String totp = loginData.getTotp(); // Get TOTP from loginData
        totp = totp.replace(" ", ""); // Remove spaces from TOTP

        if (user.isTwoFactorAuthEnabled()) {
            System.out.println("User's secret key: " + user.getSecretKey());
            System.out.println("Received TOTP: " + totp);
            if (totp == null || !twoFactorAuthService.validateCode(user.getSecretKey(), totp)) {
                System.out.println("Invalid TOTP.");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid TOTP.");
            }
            System.out.println("TOTP validated successfully.");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        final String jwt = jwtGenerator.generateToken(authentication);

        Map<String, Object> response = new HashMap<>();
        response.put("jwt", jwt);
        response.put("user", user);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.findUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{userId}/wallet")
    public ResponseEntity<?> updateWalletAddress(@PathVariable Long userId, @RequestBody String walletAddress) {
        userService.updateWalletAddress(userId, walletAddress);
        return ResponseEntity.ok().build();
    }

}