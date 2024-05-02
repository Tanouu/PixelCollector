package com.ethan.ai115.pixelcollector.service;

import com.ethan.ai115.pixelcollector.model.Bid;

public interface BidService {

    Bid getBid(Long id);
    Bid createBid(Bid bid);

}
