package com.ethan.ai115.pixelcollector.dto;

import com.ethan.ai115.pixelcollector.model.NFT;
import com.ethan.ai115.pixelcollector.model.User;

import java.time.LocalDateTime;

public class SellDto {

    private Long id;

    private User seller;

    private NFT nft;

    private Double prix;

    private LocalDateTime dateVente;

    public SellDto() {
    }

    public SellDto(Long id, User acheteur, NFT nft, Double prix, LocalDateTime dateVente) {
        this.id = id;
        this.seller = acheteur;
        this.nft = nft;
        this.prix = prix;
        this.dateVente = dateVente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public NFT getNft() {
        return nft;
    }

    public void setNft(NFT nft) {
        this.nft = nft;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public LocalDateTime getDateVente() {
        return dateVente;
    }

    public void setDateVente(LocalDateTime dateVente) {
        this.dateVente = dateVente;
    }

    @Override
    public String toString() {
        return "VenteDto{" +
                "id=" + id +
                ", acheteur=" + seller +
                ", nft=" + nft +
                ", prix=" + prix +
                ", dateVente=" + dateVente +
                '}';
    }
}
