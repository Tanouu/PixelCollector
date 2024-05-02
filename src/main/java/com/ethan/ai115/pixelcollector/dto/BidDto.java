package com.ethan.ai115.pixelcollector.dto;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class BidDto {

    private Long userId;
    private double amount;
    private OffsetDateTime timestamp;

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

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }
}