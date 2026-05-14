package com.rohitksdev.taskmanagement.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rohitksdev.taskmanagement.entity.Task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonTaskRepository implements  TaskRepository{
    private final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .enable(SerializationFeature.INDENT_OUTPUT);

    private final Path storagePath;

    public JsonTaskRepository() {
        this(defaultStoragePath());
    }

    public JsonTaskRepository(Path storagePath) {
        this.storagePath = storagePath;
    }

    private static Path defaultStoragePath() {
        return Paths.get(
                System.getProperty("user.home"),
                ".task-management-cli",
                "tasks.json"
        );
    }

    @Override
    public List<Task> findAll() throws IOException {
        if (!Files.exists(storagePath)) {
            return new ArrayList<>();
        }

        return mapper.readValue(
                storagePath.toFile(),
                new TypeReference<List<Task>>() {}
        );
    }

    @Override
    public boolean save(Task task) throws IOException {
        List<Task> tasks = findAll();
        tasks.add(task);
        saveAll(tasks);
        return true;
    }

    @Override
    public boolean saveAll(List<Task> tasks) throws IOException {
        Path parentDir = storagePath.getParent();
        if (parentDir != null) {
            Files.createDirectories(parentDir);
        }

        mapper.writeValue(storagePath.toFile(), tasks);
        return true;
    }

    @Override
    public boolean deleteById(String id) throws IOException {
        List<Task> tasks =  findAll();
        boolean removed = tasks.removeIf(
                task -> task.getId().equals(id)
        );

        if (removed) {
            saveAll(tasks);
        }

        return removed;

    }
}
