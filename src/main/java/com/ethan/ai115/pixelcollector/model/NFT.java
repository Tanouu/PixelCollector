package com.ethan.ai115.pixelcollector.model;

import jakarta.persistence.*;

@Entity
@Table(name = "nft")
public class NFT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rarity" , nullable = false)
    private String rarity;

    @Column(name = "photo" , nullable = false)
    private String photo;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "NFT{" +
                "id=" + id +
                ", rarity='" + rarity + '\'' +
                ", photo='" + photo + '\'' +
                ", owner=" + owner +
                '}';
    }
}