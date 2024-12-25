package com.spinel.hexagonal.infrastructure.controllers;

import com.spinel.hexagonal.application.services.TaskService;
import com.spinel.hexagonal.domain.models.AdditionalTaskInfo;
import com.spinel.hexagonal.domain.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(
                createdTask,
                HttpStatus.CREATED
        );
    }

    @GetMapping("{task-id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("task-id") Long taskId) {
        return taskService
                .getTaskById(taskId)
                .map(task -> new ResponseEntity<>(
                        task,
                        HttpStatus.OK
                ))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(
                tasks,
                HttpStatus.OK
        );
    }

    @PutMapping("{task-id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable("task-id") Long taskId,
            @RequestBody Task updateTask
    ) {
        return taskService
                .updateTask(
                        taskId,
                        updateTask
                )
                .map(task -> new ResponseEntity<>(
                        task,
                        HttpStatus.OK
                ))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{task-id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("task-id") Long taskId) {
        return new ResponseEntity<>(taskService.deleteTask(taskId)
                                    ? HttpStatus.NO_CONTENT
                                    : HttpStatus.NOT_FOUND);
    }

    @GetMapping("{task-id}/additional-info")
    public ResponseEntity<AdditionalTaskInfo> getAdditionalTaskInfo(@PathVariable("task-id") Long taskId) {
        AdditionalTaskInfo additionalTaskInfo = taskService.getAdditionalTaskInfo(taskId);
        return new ResponseEntity<>(
                additionalTaskInfo,
                HttpStatus.OK
        );
    }
}
