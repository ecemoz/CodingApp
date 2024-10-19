package com.galata.codingapp.service;

import com.galata.codingapp.model.Achievement;
import com.galata.codingapp.repository.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    public List<Achievement> getAllAchievements() {
        return achievementRepository.findAll();
    }

    public Optional< Achievement > getAchievementById(Long id) {
        return achievementRepository.findById(id);
    }

    public List<Achievement> getAchievementByUsername(String username) {
        return achievementRepository.findByUsername(username);
    }

    public List<Achievement> getAchievementByUserId(Long id) {
        return achievementRepository.findByUserId(id);
    }

    public Achievement createAchievement(Achievement achievement) {
        return achievementRepository.save(achievement);
    }

    public Achievement updateAchievement(Long id , Achievement updatedAchievement) {
        return achievementRepository.findById(id)
                .map (achievement -> {
                    achievement.setName(updatedAchievement.getName());
                    achievement.setDescription(updatedAchievement.getDescription());
                    achievement.setCriteria(updatedAchievement.getCriteria());
                    return achievementRepository.save(achievement);
                })
                .orElseThrow(() -> new RuntimeException("Achievement not found"));
    }

    public void deleteAchievement(Long id) {
        if (achievementRepository.existsById(id)) {
            achievementRepository.deleteById(id);
        } else {
            throw new RuntimeException("Achievement not found");
        }
    }
}
    
