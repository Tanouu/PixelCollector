package com.ethan.ai115.pixelcollector.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login" , nullable = false , unique = true)
    private String login;

    @Column(name = "password" , nullable = false)
    private String password;
}
