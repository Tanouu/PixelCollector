package com.ethan.ai115.pixelcollector.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username" , nullable = false , unique = true)
    private String username;

    @Column(name = "password" , nullable = false)
    private String password;

    @Column(name = "email" , nullable = false , unique = true)
    private String email;

    @Column(name = "birthDate" , nullable = false)
    private LocalDate birthDate;

    @Column(name = "walletAddress" , nullable = false , unique = true)
    private String walletAddress;

    @Column(name = "2faEnabled" , nullable = false)
    private boolean twoFactorAuthEnabled;

    @Column(name= "photo" , nullable = true)
    private String photo;
}
