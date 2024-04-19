package com.ethan.ai115.pixelcollector.model;

import jakarta.persistence.*;

@Entity
@Table(name = "collections")
public class Collection {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_NFT" , nullable = false)
    private Long id_NFT;

    @Column(name = "id_user" , nullable = false)
    private Long id_user;

}
