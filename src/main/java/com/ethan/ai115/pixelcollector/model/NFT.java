package com.ethan.ai115.pixelcollector.model;

import jakarta.persistence.*;

@Entity
@Table(name = "NFT")
public class NFT {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rarity" , nullable = false)
    private String rarity;

    @Column(name = "photo" , nullable = false)
    private String photo;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;
}