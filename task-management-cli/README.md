# Task Management CLI

A simple command-line app to manage tasks with JSON file persistence.

## Features

- Add a task
- List all tasks
- Filter tasks by status
- Update task status
- Mark a task as done
- Update task description
- Delete a task

## Requirements

- Java 23
- Maven 3.9+

## Build

From repo root:

```bash
mvn -pl task-management-cli clean package
```

From module directory:

```bash
mvn clean package
```

## Run

From repo root:

```bash
mvn -pl task-management-cli exec:java -Dexec.mainClass="com.rohitksdev.taskmanagement.Main" -Dexec.args="list"
```

From module directory:

```bash
mvn exec:java -Dexec.mainClass="com.rohitksdev.taskmanagement.Main" -Dexec.args="list"
```

## Commands

```text
add <description>
list
list <status>
delete <id>
mark-done <id>
update-status <id> <status>
update-desc <id> <description>
```

### Valid Status Values

- `todo`
- `in-progress`
- `done`

## Examples

```bash
# Add a task
mvn -pl task-management-cli exec:java -Dexec.mainClass="com.rohitksdev.taskmanagement.Main" -Dexec.args="add \"Buy groceries\""

# List all tasks
mvn -pl task-management-cli exec:java -Dexec.mainClass="com.rohitksdev.taskmanagement.Main" -Dexec.args="list"

# List only in-progress tasks
mvn -pl task-management-cli exec:java -Dexec.mainClass="com.rohitksdev.taskmanagement.Main" -Dexec.args="list in-progress"

# Mark a task as done
mvn -pl task-management-cli exec:java -Dexec.mainClass="com.rohitksdev.taskmanagement.Main" -Dexec.args="mark-done <task-id>"

# Update a task status
mvn -pl task-management-cli exec:java -Dexec.mainClass="com.rohitksdev.taskmanagement.Main" -Dexec.args="update-status <task-id> done"

# Update a task description
mvn -pl task-management-cli exec:java -Dexec.mainClass="com.rohitksdev.taskmanagement.Main" -Dexec.args="update-desc <task-id> \"Prepare Java interview notes\""

# Delete a task
mvn -pl task-management-cli exec:java -Dexec.mainClass="com.rohitksdev.taskmanagement.Main" -Dexec.args="delete <task-id>"
```

## Data Storage

- Tasks are stored in:
  - `~/.task-management-cli/tasks.json`
- This path is independent of your current working directory.

## Error Handling

- Storage-related failures are caught in the CLI layer and shown as user-friendly messages.
- IO exceptions are propagated through repository/service layers for consistency.
