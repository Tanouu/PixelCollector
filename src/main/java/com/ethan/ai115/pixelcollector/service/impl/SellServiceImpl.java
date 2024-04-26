package com.ethan.ai115.pixelcollector.service.impl;


import com.ethan.ai115.pixelcollector.dto.BuyNFTRequest;
import com.ethan.ai115.pixelcollector.dto.SellDto;
import com.ethan.ai115.pixelcollector.model.NFT;
import com.ethan.ai115.pixelcollector.model.Sell;
import com.ethan.ai115.pixelcollector.model.User;
import com.ethan.ai115.pixelcollector.repository.NFTRepository;
import com.ethan.ai115.pixelcollector.repository.SellRepository;
import com.ethan.ai115.pixelcollector.repository.UserRepository;
import com.ethan.ai115.pixelcollector.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SellServiceImpl implements SellService {

@Autowired
    private SellRepository sellRepository;

    @Autowired
    public SellServiceImpl(SellRepository sellRepository) {
        this.sellRepository = sellRepository;
    }

    @Autowired
    private NFTRepository nftRepository;
    @Autowired
    private UserRepository userRepository;

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

    @Override
    public void buyNFT(BuyNFTRequest request) {
        NFT nft = nftRepository.findById(request.getNftId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "NFT not found"));
        User buyer = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));
        nft.setOwner(buyer);
        nftRepository.save(nft);
    }

    @Override
    public void deleteSell(Long saleId) {
        if (!sellRepository.existsById(saleId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sale not found");
        }
        sellRepository.deleteById(saleId);
    }
}

