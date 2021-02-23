package com.stags.seriesGuide.repository;

import com.stags.seriesGuide.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
