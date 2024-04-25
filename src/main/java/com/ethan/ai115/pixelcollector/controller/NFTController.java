package com.ethan.ai115.pixelcollector.controller;

import com.ethan.ai115.pixelcollector.model.NFT;
import com.ethan.ai115.pixelcollector.service.NFTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nft")
public class NFTController {

    private NFTService nftService;

    @Autowired
    public NFTController(NFTService nftService) {
        this.nftService = nftService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<NFT> getNFT(@PathVariable Long id) {
        NFT nft = nftService.getNFT(id);
        if (nft == null) {
            return ResponseEntity.notFound().build();
        }
        System.out.println(nft); // Ajoutez ce log
        return ResponseEntity.ok(nft);
    }

           @GetMapping("/user/{userId}")
        public ResponseEntity<List<NFT>> getNFTsByUser(@PathVariable Long userId) {
            List<NFT> nfts = nftService.getNFTsByUserId(userId);
            if (nfts.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(nfts);
}

}