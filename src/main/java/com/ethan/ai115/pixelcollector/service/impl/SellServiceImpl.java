package com.ethan.ai115.pixelcollector.service.impl;


import com.ethan.ai115.pixelcollector.model.NFT;
import com.ethan.ai115.pixelcollector.model.Sell;
import com.ethan.ai115.pixelcollector.model.User;
import com.ethan.ai115.pixelcollector.repository.SellRepository;
import com.ethan.ai115.pixelcollector.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellServiceImpl implements SellService {


    private SellRepository sellRepository;

    @Autowired
    public SellServiceImpl(SellRepository sellRepository) {
        this.sellRepository = sellRepository;
    }


    @Override
    public Sell sellNFT(NFT nft, User seller, Double price) {
        return null;
    }

    @Override
    public List<Sell> getSales() {
        return sellRepository.findAll();
    }
}
