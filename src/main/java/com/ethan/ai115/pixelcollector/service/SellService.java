package com.ethan.ai115.pixelcollector.service;

import com.ethan.ai115.pixelcollector.dto.BuyNFTRequest;
import com.ethan.ai115.pixelcollector.dto.SellDto;
import com.ethan.ai115.pixelcollector.model.Sell;

import java.util.List;

public interface SellService {

    Sell registerSellNFT(SellDto sellDto);

    List<Sell> getSales(
    );

    void buyNFT(BuyNFTRequest request);

    void deleteSell(Long saleId);

    boolean isNftOnSale(Long nftId);

}
