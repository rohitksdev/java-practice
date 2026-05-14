package com.rohitksdev.taskmanagement;

import com.rohitksdev.taskmanagement.cli.CliCommandHandler;
import com.rohitksdev.taskmanagement.repository.JsonTaskRepository;
import com.rohitksdev.taskmanagement.repository.TaskRepository;
import com.rohitksdev.taskmanagement.service.TaskService;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private static final Path TASKS_FILE_PATH = resolveTasksFilePath();

    private static final TaskRepository taskRepository =
            new JsonTaskRepository(TASKS_FILE_PATH);

    private static final TaskService taskService =
            new TaskService(taskRepository);

    public static void main(String[] args) {
        CliCommandHandler commandHandler = new CliCommandHandler(taskService);
        commandHandler.handle(args);
    }

    private static Path resolveTasksFilePath() {
        return Paths.get(
                System.getProperty("user.home"),
                ".task-management-cli",
                "tasks.json"
        );
    }
}
