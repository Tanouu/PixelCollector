package com.ethan.ai115.pixelcollector.dto;

public class BidPlacementResponseDto {

    private Long auctionId;
    private Long userId;
    private double amount;

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
// Getters and setters
}
