package com.ethan.ai115.pixelcollector.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nft_id", referencedColumnName = "id")
    private NFT nft;

    private Double prix;
    private LocalDateTime dateSale;
    private LocalDateTime dateBuy;

    //pour le vendeur de la table users
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getDateSale() {
        return dateSale;
    }

    public void setDateSale(LocalDateTime dateSale) {
        this.dateSale = dateSale;
    }

    public LocalDateTime getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(LocalDateTime dateBuy) {
        this.dateBuy = dateBuy;
    }



    @Override
    public String toString() {
        return "Sell{" +
                "id=" + id +
                ", nft=" + nft +
                ", prix=" + prix +
                ", dateSale=" + dateSale +
                ", dateBuy=" + dateBuy +
                '}';
    }
}



