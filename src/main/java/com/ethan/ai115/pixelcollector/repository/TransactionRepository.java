package com.ethan.ai115.pixelcollector.repository;

import com.ethan.ai115.pixelcollector.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}

