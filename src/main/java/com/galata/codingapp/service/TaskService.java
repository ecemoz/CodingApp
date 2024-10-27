package com.galata.codingapp.service;

import com.galata.codingapp.model.Task;
import com.galata.codingapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> getTasksByName(String name) {
        return taskRepository.findByName(name);
    }

    public List<Task> getTasksByCategory(String category) {
        return taskRepository.findByCategories_Name(category);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setName(updatedTask.getName());
                    task.setDescription(updatedTask.getDescription());
                    task.setLevel(updatedTask.getLevel());
                    task.setCodeTemplate(updatedTask.getCodeTemplate());
                    task.setSolution(updatedTask.getSolution());
                    task.setHint(updatedTask.getHint());
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

//    updateTask Function with if-else.
//    public Task updateTask(Long id, Task updatedTask) {
//        Optional<Task> existingTask = taskRepository.findById(id);
//        if (existingTask.isPresent()) {
//            Task task = existingTask.get();
//            task.setName(updatedTask.getName());
//            task.setDescription(updatedTask.getDescription());
//            task.setLevel(updatedTask.getLevel());
//            task.setCodeTemplate(updatedTask.getCodeTemplate());
//            task.setSolution(updatedTask.getSolution());
//            task.setHint(updatedTask.getHint());
//            return taskRepository.save(task);
//        } else {
//            throw new RuntimeException("Task not found");
//        }
//    }

    public void deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        } else {
            throw new RuntimeException("Task not found");
        }
    }
}
