package com.ethan.ai115.pixelcollector.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "auctions")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nft_id", nullable = false)
    private NFT nft;

    @Column(name = "startDate" , nullable = false)
    private LocalDateTime startDate;

    @Column(name = "endDate" , nullable = false)
    private LocalDateTime endDate;

    @Column(name = "currentPrice" , nullable = false)
    private double currentPrice;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @OneToMany(mappedBy = "auction", fetch = FetchType.EAGER)
    private List<Bid> bids;

    @OneToOne
    @JoinColumn(name = "highest_bid_id")
    private Bid highestBid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NFT getNft() {
        return nft;
    }

    public void setNft(NFT nft) {
        this.nft = nft;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public Bid getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(Bid highestBid) {
        this.highestBid = highestBid;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "id=" + id +
                ", nft=" + nft +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", currentPrice=" + currentPrice +
                ", owner=" + owner +
                ", bids=" + bids +
                ", highestBid=" + highestBid +
                '}';
    }
}