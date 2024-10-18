package com.galata.codingapp.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int level;

    @Column(nullable = false)
    private String codeTemplate;

    @Column(nullable = false)
    private String solution;

    @Column
    private String hint;

    @ManyToMany(mappedBy = "tasksCompleted")
    private List<User> completedBy;

    @ManyToMany
    @JoinTable(
            name = "task_categories",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    public Task() {
    }

    public Task(String name, String description, int level, String codeTemplate, String solution, String hint) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.codeTemplate = codeTemplate;
        this.solution = solution;
        this.hint = hint;
    }
}


