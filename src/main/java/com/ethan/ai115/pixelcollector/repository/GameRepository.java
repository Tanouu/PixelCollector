package com.ethan.ai115.pixelcollector.repository;

import com.ethan.ai115.pixelcollector.model.Collection;
import com.ethan.ai115.pixelcollector.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
