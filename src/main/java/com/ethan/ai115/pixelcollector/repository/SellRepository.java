package com.ethan.ai115.pixelcollector.repository;

import com.ethan.ai115.pixelcollector.model.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellRepository extends JpaRepository<Sell, Long> {

    List <Sell> findAll();
}
