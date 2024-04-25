package com.ethan.ai115.pixelcollector.service;

import com.ethan.ai115.pixelcollector.model.NFT;

import java.util.List;

public interface NFTService {

    NFT getNFT(Long id);
    List<NFT> getNFTsByUserId(Long userId);
}
