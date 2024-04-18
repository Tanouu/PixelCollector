package com.ethan.ai115.pixelcollector.repository;

import com.ethan.ai115.pixelcollector.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
