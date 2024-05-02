package com.ethan.ai115.pixelcollector.repository;

import com.ethan.ai115.pixelcollector.model.Auction;
import com.ethan.ai115.pixelcollector.model.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    Optional<Auction> findByNftId(Long nftId);
}
