package com.ethan.ai115.pixelcollector.controller;

import com.ethan.ai115.pixelcollector.dto.AuctionDto;
import com.ethan.ai115.pixelcollector.dto.BidDto;
import com.ethan.ai115.pixelcollector.dto.BidResponseDto;
import com.ethan.ai115.pixelcollector.model.Auction;
import com.ethan.ai115.pixelcollector.model.Bid;
import com.ethan.ai115.pixelcollector.model.User;
import com.ethan.ai115.pixelcollector.service.AuctionService;
import com.ethan.ai115.pixelcollector.service.BidService;
import com.ethan.ai115.pixelcollector.service.SellService;
import com.ethan.ai115.pixelcollector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private BidService bidService;

    @Autowired
    private UserService userService;

    @Autowired
    private SellService sellService;

    @PostMapping("/create")
    public ResponseEntity<?> createAuction(@RequestBody AuctionDto auctionDto) {
        if (auctionService.isNftOnAuction(auctionDto.getNftId())) {
            return ResponseEntity.badRequest().body("The NFT is already on auction.");
        }
        if (sellService.isNftOnSale(auctionDto.getNftId())) {
            return ResponseEntity.badRequest().body("The NFT is already on sale.");
        }
        return ResponseEntity.ok(auctionService.createAuction(auctionDto));
    }
    @PostMapping("/{auctionId}/bids")
    public ResponseEntity<?> placeBid(@PathVariable Long auctionId, @RequestBody BidDto bidDto) {
        // Validation des entrées
        if (bidDto.getAmount() <= 0) {
            return ResponseEntity.badRequest().body("The bid amount must be positive.");
        }

        Auction auction = auctionService.getAuction(auctionId);
        User user = userService.findUserById(bidDto.getUserId());

        // Gestion des erreurs
        if (auction == null) {
            return ResponseEntity.notFound().build();
        }
        if (user == null) {
            return ResponseEntity.badRequest().body("The user does not exist.");
        }

        Bid bid = new Bid();
        bid.setAuction(auction);
        bid.setUser(user);
        bid.setAmount(bidDto.getAmount());
        bid.setTimestamp(bidDto.getTimestamp());

        Bid createdBid = bidService.createBid(bid);

        return ResponseEntity.ok(auctionService.placeBid(createdBid));
    }

    @GetMapping("/{auctionId}/bids")
    public ResponseEntity<List<BidResponseDto>> getBidsForAuction(@PathVariable Long auctionId) {
        List<Bid> bids = auctionService.getBidsForAuction(auctionId);
        List<BidResponseDto> bidResponses = bids.stream().map(bid -> {
            BidResponseDto response = new BidResponseDto();
            response.setUserId(bid.getUser().getId());
            response.setUsername(bid.getUser().getUsername());
            response.setNftId(bid.getAuction().getNft().getId());
            response.setAmount(bid.getAmount());
            return response;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(bidResponses);
    }

    @DeleteMapping("/{auctionId}")
    public ResponseEntity<Void> deleteAuction(@PathVariable Long auctionId) {
        auctionService.deleteAuction(auctionId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{auctionId}/end")
    public ResponseEntity<?> endAuction(@PathVariable Long auctionId) {
        try {
            auctionService.endAuction(auctionId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{auctionId}/endDate")
    public ResponseEntity<LocalDateTime> getAuctionEndDate(@PathVariable Long auctionId) {
        Auction auction = auctionService.getAuction(auctionId);
        return ResponseEntity.ok(auction.getEndDate());
    }

}