package com.galata.codingapp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "submissions")
@Getter
@Setter
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private boolean isCorrect;

    @Column(nullable = false)
    private LocalDateTime submittedAt;

    public Submission() {
    }

    public Submission(User user, Task task, String code, boolean isCorrect, LocalDateTime submittedAt) {
        this.user = user;
        this.task = task;
        this.code = code;
        this.isCorrect = isCorrect;
        this.submittedAt = submittedAt;
    }
}
