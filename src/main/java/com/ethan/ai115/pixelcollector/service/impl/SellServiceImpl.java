package com.ethan.ai115.pixelcollector.service.impl;


import com.ethan.ai115.pixelcollector.dto.SellDto;
import com.ethan.ai115.pixelcollector.model.Sell;
import com.ethan.ai115.pixelcollector.repository.NFTRepository;
import com.ethan.ai115.pixelcollector.repository.SellRepository;
import com.ethan.ai115.pixelcollector.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SellServiceImpl implements SellService {


    private SellRepository sellRepository;

    @Autowired
    public SellServiceImpl(SellRepository sellRepository) {
        this.sellRepository = sellRepository;
    }

    @Autowired
    private NFTRepository nftRepository;

  @Override
public Sell registerSellNFT(SellDto sellDto) {
    if (sellRepository.existsByNft(sellDto.getNft())) {
        throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "NFT is already for sale");
    }
    Sell newSell = new Sell();
    newSell.setNft(sellDto.getNft());
    newSell.setPrix(sellDto.getPrix());
    newSell.setDateSale(sellDto.getDateVente());
    newSell.setDateBuy(sellDto.getDateVente());
    return sellRepository.save(newSell);
}

    @Override
    public List<Sell> getSales() {
        return sellRepository.findAll();
    }
}
