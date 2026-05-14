package com.rohitksdev.taskmanagement.cli;

import com.rohitksdev.taskmanagement.entity.Task;
import com.rohitksdev.taskmanagement.enums.TaskStatus;
import com.rohitksdev.taskmanagement.service.TaskService;
import com.rohitksdev.taskmanagement.utils.TaskTablePrinter;

import java.io.IOException;
import java.util.List;

public class CliCommandHandler {
    private final TaskService taskService;

    public CliCommandHandler(TaskService taskService) {
        this.taskService = taskService;
    }

    public void handle(String[] args) {
        if (args.length == 0) {
            printUsage("Invalid, please provide the arguments");
            return;
        }

        try {
            String command = args[0];
            switch (command) {
                case "add":
                    if (!requireArgs(command, args, 2)) {
                        return;
                    }
                    addTask(args[1]);
                    break;
                case "list":
                    handleListCommand(args);
                    break;
                case "delete":
                    if (!requireArgs(command, args, 2)) {
                        return;
                    }
                    deleteTask(args[1]);
                    break;
                case "mark-done":
                    if (!requireArgs(command, args, 2)) {
                        return;
                    }
                    markTaskDone(args[1]);
                    break;
                case "update-status":
                    if (!requireArgs(command, args, 3)) {
                        return;
                    }
                    updateTaskStatus(args[1], args[2]);
                    break;
                case "update-desc":
                    if (!requireArgs(command, args, 3)) {
                        return;
                    }
                    updateTaskDesc(args[1], args[2]);
                    break;
                default:
                    printUsage("Invalid command: " + command);
                    break;
            }
        } catch (IOException e) {
            System.out.println("Unable to process task command due to a storage error.");
            System.out.println("Details: " + e.getMessage());
        }
    }

    private void handleListCommand(String[] args) throws IOException {
        if (args.length == 1) {
            listTasks();
            return;
        }

        if (args.length == 2) {
            filterTasks(args[1]);
            return;
        }

        printUsage("Command 'list' accepts zero or one argument.");
    }

    private boolean requireArgs(String command, String[] args, int expectedCount) {
        if (args.length != expectedCount) {
            printUsage(
                    "Command '" + command + "' expects " + (expectedCount - 1)
                            + " argument(s). Received: " + (args.length - 1)
            );
            return false;
        }
        return true;
    }

    private void updateTaskDesc(String id, String desc) throws IOException {
        boolean success = taskService.updateTaskDesc(id, desc);
        if (success) {
            System.out.println("Successfully updated the task");
        } else {
            System.out.println("Unable to update the task");
        }
    }

    private void updateTaskStatus(String id, String status) throws IOException {
        TaskStatus taskStatus = parseStatus(status);
        if (taskStatus == null) {
            return;
        }

        boolean success = taskService.updateTaskStatus(id, taskStatus);
        if (success) {
            System.out.println("Successfully updated the task");
        } else {
            System.out.println("Unable to update the task");
        }
    }

    private void markTaskDone(String id) throws IOException {
        boolean success = taskService.updateTaskStatus(id, TaskStatus.DONE);
        if (success) {
            System.out.println("Successfully updated the task");
        } else {
            System.out.println("Unable to update the task");
        }
    }

    private void addTask(String taskDesc) throws IOException {
        Task task = new Task(taskDesc);
        boolean success = taskService.saveTask(task);
        if (success) {
            System.out.println("Successfully added the task");
        } else {
            System.out.println("Unable to add the task");
        }
    }

    private void listTasks() throws IOException {
        List<Task> tasks = taskService.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found!");
        } else {
            TaskTablePrinter.printTasks(tasks);
        }
    }

    private void deleteTask(String id) throws IOException {
        boolean success = taskService.deleteTask(id);
        if (success) {
            System.out.println("Successfully deleted the task");
        } else {
            System.out.println("Unable to delete the task");
        }
    }

    private void filterTasks(String status) throws IOException {
        TaskStatus taskStatus = parseStatus(status);
        if (taskStatus == null) {
            return;
        }

        List<Task> tasks = taskService.filterTasksByStatus(taskStatus);
        if (tasks.isEmpty()) {
            System.out.println("No tasks found!");
        } else {
            TaskTablePrinter.printTasks(tasks);
        }
    }

    private TaskStatus parseStatus(String status) {
        try {
            return TaskStatus.fromString(status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void printUsage(String message) {
        System.out.println(message);
        System.out.println("Usage:");
        System.out.println("  add <description>");
        System.out.println("  list");
        System.out.println("  list <status>");
        System.out.println("  delete <id>");
        System.out.println("  mark-done <id>");
        System.out.println("  update-status <id> <status>");
        System.out.println("  update-desc <id> <description>");
    }
}
