package com.ethan.ai115.pixelcollector.service;

import com.ethan.ai115.pixelcollector.dto.AuctionDto;
import com.ethan.ai115.pixelcollector.model.Auction;
import com.ethan.ai115.pixelcollector.model.Bid;

import java.util.List;

public interface AuctionService {

    Auction createAuction(AuctionDto auctionDto);
    Bid placeBid(Bid bid);
    List<Bid> getBidsForAuction(Long auctionId);
    Auction getAuction(Long id);
    List<Auction> getAllAuctions();

    void deleteAuction(Long auctionId);
    boolean isNftOnAuction(Long nftId);

    void endAuction(Long auctionId);
}