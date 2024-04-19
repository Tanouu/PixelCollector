package com.ethan.ai115.pixelcollector.repository;

import com.ethan.ai115.pixelcollector.model.NFT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NFTRepository extends JpaRepository<NFT, Long> {
}
