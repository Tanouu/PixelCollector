package com.ethan.ai115.pixelcollector.controller;

import com.ethan.ai115.pixelcollector.dto.SellDto;
import com.ethan.ai115.pixelcollector.model.Sell;
import com.ethan.ai115.pixelcollector.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sell")
public class SellController {

    @Autowired
    private SellService SellService;

    @PostMapping("/register")
    public ResponseEntity<Sell> registerSellNFT(@RequestBody SellDto sellDto) {
        Sell newSell = SellService.registerSellNFT(sellDto);
        return ResponseEntity.ok(newSell);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Sell>> listerToutesLesVentes() {
        List<Sell> ventes = SellService.getSales();
        return ResponseEntity.ok(ventes);
    }
}
