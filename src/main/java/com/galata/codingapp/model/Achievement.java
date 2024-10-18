package com.galata.codingapp.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "achievements")
@Getter
@Setter
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String criteria;

    @ManyToMany(mappedBy = "achievements")
    private List<User> users;

    public Achievement() {
    }

    public Achievement(String name, String description, String criteria) {
        this.name = name;
        this.description = description;
        this.criteria = criteria;
    }
}

