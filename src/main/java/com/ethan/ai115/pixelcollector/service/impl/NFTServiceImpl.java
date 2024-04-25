package com.ethan.ai115.pixelcollector.service.impl;

import com.ethan.ai115.pixelcollector.model.NFT;
import com.ethan.ai115.pixelcollector.repository.NFTRepository;
import com.ethan.ai115.pixelcollector.service.NFTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NFTServiceImpl implements NFTService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NFTServiceImpl.class);

    private NFTRepository nftRepository;

    @Autowired
    public NFTServiceImpl(NFTRepository nftRepository) {
        this.nftRepository = nftRepository;
    }

    @Override
    public NFT getNFT(Long id) {
        Optional<NFT> optionalNFT = nftRepository.findById(id);
        if (optionalNFT.isPresent()) {
            NFT nft = optionalNFT.get();
            System.out.println(nft); // Ajoutez ce log
            return nft;
        } else {
            return null;
        }
    }

    @Override
public List<NFT> getNFTsByUserId(Long userId) {
    return nftRepository.findByOwnerId(userId);
}
}