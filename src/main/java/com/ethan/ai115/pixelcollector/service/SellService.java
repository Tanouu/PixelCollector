package com.ethan.ai115.pixelcollector.service;

import com.ethan.ai115.pixelcollector.model.NFT;
import com.ethan.ai115.pixelcollector.model.Sell;
import com.ethan.ai115.pixelcollector.model.User;

import java.util.List;

public interface SellService {

    Sell sellNFT(NFT nft, User seller, Double price);
    List<Sell> getSales(
    );
}
