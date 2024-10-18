package com.galata.codingapp.repository;

import com.galata.codingapp.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    List<Achievement>findByUsername(String username);
    List<Achievement>findByUserId(Long id);
}
