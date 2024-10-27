package com.galata.codingapp.repository;

import com.galata.codingapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCategories_Name(String categoryName);
    List<Task> findByName(String name);
}
