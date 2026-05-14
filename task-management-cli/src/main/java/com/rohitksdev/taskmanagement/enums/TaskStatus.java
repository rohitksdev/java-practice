package com.rohitksdev.taskmanagement.enums;

public enum TaskStatus {
    TODO("todo"),
    IN_PROGRESS("in-progress"),
    DONE("done");

    private final String value;

    TaskStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TaskStatus fromString(String val) {
        for (TaskStatus status : values()) {
            if (status.getValue().equals(val) ) {
                return status;
            }
        }

        throw new IllegalArgumentException(
                "Invalid task status: " + val
        );
    }
}
