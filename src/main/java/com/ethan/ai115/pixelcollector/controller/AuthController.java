package com.ethan.ai115.pixelcollector.controller;

import com.ethan.ai115.pixelcollector.model.User;
import com.ethan.ai115.pixelcollector.repository.UserRepository;
import com.ethan.ai115.pixelcollector.service.impl.TwoFactorAuthenticationServiceImpl;
import dev.samstevens.totp.exceptions.QrGenerationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private TwoFactorAuthenticationServiceImpl twoFactorAuthService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/enable-2fa")
    public ResponseEntity<String> enableTwoFactorAuth(@RequestBody User user) throws QrGenerationException {
        String secretKey = twoFactorAuthService.generateSecretKey();
        user.setSecretKey(secretKey);
        userRepository.save(user);

        String qrCodeImage = twoFactorAuthService.getUriForImage(secretKey, user.getUsername());

        return ResponseEntity.ok(qrCodeImage);
    }
}
