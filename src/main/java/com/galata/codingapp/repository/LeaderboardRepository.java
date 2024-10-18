package com.galata.codingapp.repository;

import com.galata.codingapp.model.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LeaderboardRepository extends JpaRepository<Leaderboard, Long> {
    List<Leaderboard> findAllByOrderByScoreDesc();
    Leaderboard findByUsername(String username);
}
