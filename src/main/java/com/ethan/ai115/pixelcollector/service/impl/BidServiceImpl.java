package com.ethan.ai115.pixelcollector.service.impl;

import com.ethan.ai115.pixelcollector.model.Bid;
import com.ethan.ai115.pixelcollector.repository.BidRepository;
import com.ethan.ai115.pixelcollector.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidRepository bidRepository;

    @Override
    public Bid getBid(Long id) {
        return bidRepository.findById(id).orElseThrow(() -> new RuntimeException("Bid not found"));
    }

    @Override
    public Bid createBid(Bid bid) {
        return bidRepository.save(bid);
    }

}