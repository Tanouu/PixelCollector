package com.ethan.ai115.pixelcollector.repository;

import com.ethan.ai115.pixelcollector.model.NFT;
import com.ethan.ai115.pixelcollector.model.Sell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SellRepository extends JpaRepository<Sell, Long> {

    List <Sell> findAll();

    boolean existsByNft(NFT nft);


    Optional<Sell> findByNftId(Long nftId);
}
