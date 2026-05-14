package com.rohitksdev.taskmanagement.repository;

import com.rohitksdev.taskmanagement.entity.Task;

import java.io.IOException;
import java.util.List;

public interface TaskRepository {
    List<Task> findAll() throws IOException;
    boolean save(Task task) throws IOException;
    boolean saveAll(List<Task> tasks) throws IOException;
    boolean deleteById(String id) throws IOException;
}
