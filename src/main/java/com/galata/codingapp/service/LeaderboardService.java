package com.galata.codingapp.service;

import com.galata.codingapp.model.Leaderboard;
import com.galata.codingapp.repository.LeaderboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeaderboardService {

    @Autowired
    private LeaderboardRepository leaderboardRepository;

    public List<Leaderboard> getAllLeaderboardsOrderedByScore() {
        return leaderboardRepository.findAllByOrderByScoreDesc();
    }

    public Leaderboard getLeaderboardByUsername(String username) {
        return leaderboardRepository.findByUsername(username);
    }

    public Leaderboard createLeaderboardEntry(Leaderboard leaderboard) {
        return leaderboardRepository.save(leaderboard);
    }

    public Leaderboard updateLeaderboardEntry(Long id,Leaderboard updatedLeaderboard) {
        return leaderboardRepository.findById(id)
                .map(leaderboard -> {
                    leaderboard.setScore(updatedLeaderboard.getScore());
                    leaderboard.setRank(updatedLeaderboard.getRank());
                    return leaderboardRepository.save(leaderboard);
                })
                .orElseThrow(() -> new RuntimeException("Leaderboard not found"));
    }

    public void deleteLeaderboardEntry(Long id) {
        if (leaderboardRepository.existsById(id)) {
            leaderboardRepository.deleteById(id);
        } else {
            throw new RuntimeException("Leaderboard not found");
        }
    }
}
