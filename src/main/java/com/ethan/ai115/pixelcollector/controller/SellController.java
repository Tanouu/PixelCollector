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

    @PostMapping
    public ResponseEntity<Sell> effectuerVente(@RequestBody SellDto venteDTO) {
        // Convertissez venteDTO en entités et appelez venteService.vendreNFT(...)
        // Retournez la réponse
        return null;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Sell>> listerToutesLesVentes() {
        List<Sell> ventes = SellService.getSales();
        return ResponseEntity.ok(ventes);
    }
}
