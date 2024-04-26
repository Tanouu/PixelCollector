package com.ethan.ai115.pixelcollector.service;

import com.ethan.ai115.pixelcollector.dto.SellDto;
import com.ethan.ai115.pixelcollector.model.NFT;
import com.ethan.ai115.pixelcollector.model.Sell;
import com.ethan.ai115.pixelcollector.model.User;

import java.util.List;

public interface SellService {

    Sell registerSellNFT(SellDto sellDto);

    List<Sell> getSales(
    );
}
