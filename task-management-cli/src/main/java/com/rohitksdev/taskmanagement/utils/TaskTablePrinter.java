package com.rohitksdev.taskmanagement.utils;

import com.rohitksdev.taskmanagement.entity.Task;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class TaskTablePrinter {

    public static void printTasks(List<Task> tasks) {

        String format =
                "| %-36s | %-28s | %-12s | %-19s |%n";

        System.out.println(
                "+--------------------------------------+------------------------------+--------------+---------------------+"
        );

        System.out.printf(
                format,
                "ID",
                "Description",
                "Status",
                "Created At"
        );

        System.out.println(
                "+--------------------------------------+------------------------------+--------------+---------------------+"
        );

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "yyyy-MM-dd HH:mm:ss"
                );

        for (Task task : tasks) {

            System.out.printf(
                    format,
                    task.getId(),
                    truncate(task.getDescription(), 28),
                    task.getStatus(),
                    task.getCreatedAt().format(formatter)
            );
        }

        System.out.println(
                "+--------------------------------------+------------------------------+--------------+---------------------+"
        );
    }

    private static String truncate(
            String value,
            int maxLength
    ) {

        if (value.length() <= maxLength) {
            return value;
        }

        return value.substring(0, maxLength - 3) + "...";
    }
}
