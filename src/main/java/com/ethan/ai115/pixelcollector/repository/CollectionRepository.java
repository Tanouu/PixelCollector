package com.ethan.ai115.pixelcollector.repository;

import com.ethan.ai115.pixelcollector.model.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<Collection, Long> {
}
