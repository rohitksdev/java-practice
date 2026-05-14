package com.rohitksdev.taskmanagement.service;

import com.rohitksdev.taskmanagement.entity.Task;
import com.rohitksdev.taskmanagement.enums.TaskStatus;
import com.rohitksdev.taskmanagement.repository.TaskRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() throws IOException {
        return taskRepository.findAll();
    }

    public boolean saveTask(Task task) throws IOException {
        return taskRepository.save(task);
    }

    public boolean deleteTask(String id) throws IOException {
        return taskRepository.deleteById(id);
    }

    public List<Task> filterTasksByStatus(TaskStatus taskStatus) throws IOException {
        List<Task> tasks = getAllTasks();
        return tasks.stream().filter(task -> task.getStatus() == taskStatus).toList();
    }

    public boolean updateTaskStatus(
            String id,
            TaskStatus taskStatus
    ) throws IOException {

        List<Task> tasks = getAllTasks();

        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setStatus(taskStatus);
                task.setUpdatedAt(LocalDateTime.now());
                taskRepository.saveAll(tasks);
                return true;
            }
        }

        return false;
    }

    public boolean updateTaskDesc(String id, String desc) throws IOException {
        List<Task> tasks = getAllTasks();
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setDescription(desc);
                task.setUpdatedAt(LocalDateTime.now());
                taskRepository.saveAll(tasks);
                return true;
            }
        }

        return false;
    }
}
