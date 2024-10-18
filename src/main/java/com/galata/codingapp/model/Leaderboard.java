package com.galata.codingapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "leaderboard")
@Getter
@Setter
public class Leaderboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private int score;

    @Column(nullable = false)
    private int rank;

    public Leaderboard() {
    }

    public Leaderboard(User user, int score, int rank) {
        this.user = user;
        this.score = score;
        this.rank = rank;
    }
}
