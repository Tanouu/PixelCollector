package com.ethan.ai115.pixelcollector.dto;

public class BuyNFTRequest {
    private Long nftId;
    private Long userId;

    public Long getNftId() {
        return nftId;
    }

    public void setNftId(Long nftId) {
        this.nftId = nftId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BuyNFTRequest{" +
                "nftId=" + nftId +
                ", userId=" + userId +
                '}';
    }
}
