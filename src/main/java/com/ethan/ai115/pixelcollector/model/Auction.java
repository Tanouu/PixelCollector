package com.ethan.ai115.pixelcollector.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "auctions")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nft_id" , nullable = false)
    private Long nftId;

    @Column(name = "startDate" , nullable = false)
    private LocalDate startDate;

    @Column(name = "endDate" , nullable = false)
    private LocalDate endDate;

    @Column(name = "currentPrice" , nullable = false)
    private double currentPrice;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

}
