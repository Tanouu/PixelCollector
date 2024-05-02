package com.ethan.ai115.pixelcollector.service.impl;

import com.ethan.ai115.pixelcollector.dto.AuctionDto;
import com.ethan.ai115.pixelcollector.model.Auction;
import com.ethan.ai115.pixelcollector.model.Bid;
import com.ethan.ai115.pixelcollector.model.NFT;
import com.ethan.ai115.pixelcollector.model.User;
import com.ethan.ai115.pixelcollector.repository.AuctionRepository;
import com.ethan.ai115.pixelcollector.repository.BidRepository;
import com.ethan.ai115.pixelcollector.repository.NFTRepository;
import com.ethan.ai115.pixelcollector.repository.UserRepository;
import com.ethan.ai115.pixelcollector.service.AuctionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private NFTRepository nftRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Auction createAuction(AuctionDto auctionDto) {
        Auction auction = new Auction();
        NFT nft = nftRepository.findById(auctionDto.getNftId())
                .orElseThrow(() -> new RuntimeException("NFT not found"));
        User owner = userRepository.findById(auctionDto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("User not found")); // Récupération de l'owner
        auction.setNft(nft);
        auction.setOwner(owner); // Définition de l'owner
        auction.setStartDate(auctionDto.getStartDate());
        auction.setEndDate(auctionDto.getEndDate());
        auction.setCurrentPrice(auctionDto.getStartingPrice());
        return auctionRepository.save(auction);
    }

    @Override
    public Bid placeBid(Bid bid) {
        Auction auction = auctionRepository.findById(bid.getAuction().getId()).orElseThrow(() -> new RuntimeException("Auction not found"));
        if (auction.getCurrentPrice() < bid.getAmount()) {
            auction.setCurrentPrice(bid.getAmount());
            auction.setHighestBid(bid);
            auctionRepository.save(auction);
        }
        return bidRepository.save(bid);
    }

    @Override
    public List<Bid> getBidsForAuction(Long auctionId) {
        return bidRepository.findByAuctionId(auctionId);
    }

    @Override
    @Transactional
    public Auction getAuction(Long id) {
        return auctionRepository.findById(id).orElseThrow(() -> new RuntimeException("Auction not found"));
    }

    @Override
    public void deleteAuction(Long auctionId) {
        Auction auction = auctionRepository.findById(auctionId)
                .orElseThrow(() -> new RuntimeException("Auction not found"));

        // Set the highestBid to null
        auction.setHighestBid(null);
        auctionRepository.save(auction);

        // Delete all bids associated with the auction
        bidRepository.deleteAll(auction.getBids());

        // Delete the auction
        auctionRepository.delete(auction);
    }

    @Override
    public boolean isNftOnAuction(Long nftId) {
        return auctionRepository.findByNftId(nftId).isPresent();
    }

    @Override
    @Transactional
    public void endAuction(Long auctionId) {
        Auction auction = auctionRepository.findById(auctionId)
                .orElseThrow(() -> new RuntimeException("Auction not found"));

        if (auction.getEndDate().isAfter(LocalDateTime.now())) {
            throw new RuntimeException("The auction is not yet over.");
        }

        Bid highestBid = auction.getHighestBid();
        User highestBidder = highestBid.getUser();

        // Transfer ownership of the NFT to the highest bidder
        NFT nft = auction.getNft();
        nft.setOwner(highestBidder);
        nftRepository.save(nft);

        // Set the highestBid to null
        auction.setHighestBid(null);
        auctionRepository.save(auction);

        // Delete the highest bid
        bidRepository.delete(highestBid);

        // Delete all bids associated with the auction
        bidRepository.deleteAll(auction.getBids());

        // Delete the auction
        auctionRepository.delete(auction);
    }
}
