package com.galata.codingapp.controller;

import com.galata.codingapp.model.Leaderboard;
import com.galata.codingapp.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/leaderboards")
public class LeaderboardController {

    @Autowired
    private LeaderboardService leaderboardService;

    @GetMapping
    public List<Leaderboard> getAllLeaderboardsOrderedByScore() {
        return leaderboardService.getAllLeaderboardsOrderedByScore();
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<Leaderboard> getLeaderboardByUsername(@PathVariable String username){
        try {
            Leaderboard leaderboard = leaderboardService.getLeaderboardByUsername(username);
            return ResponseEntity.ok(leaderboard);
        } catch (RuntimeException e ) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Leaderboard>createLeaderboardEntry (@RequestBody Leaderboard leaderboard){
        Leaderboard createdEntry = leaderboardService.createLeaderboardEntry(leaderboard);
        return ResponseEntity.ok(createdEntry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Leaderboard> updateLeaderboardEntry (@PathVariable Long id , @RequestBody Leaderboard updatedLeaderboard){
        try {
            Leaderboard leaderboard = leaderboardService.updateLeaderboardEntry( id , updatedLeaderboard);
            return ResponseEntity.ok(leaderboard);
        } catch (RuntimeException e ) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeaderboardEntry (@PathVariable Long id){
        try {
            leaderboardService.deleteLeaderboardEntry(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e ) {
            return ResponseEntity.notFound().build();
        }
    }
}
