package com.ethan.ai115.pixelcollector.repository;

import com.ethan.ai115.pixelcollector.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {
    List<Bid> findByAuctionId(Long auctionId);
}
