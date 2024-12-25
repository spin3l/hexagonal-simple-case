package com.spinel.hexagonal.infrastructure.entities;

import com.spinel.hexagonal.domain.models.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class TaskEntity {

    public TaskEntity(
            Long id,
            String title,
            String description,
            LocalDateTime creationDate,
            boolean completed
    ) {
        this.id           = id;
        this.title        = title;
        this.description  = description;
        this.creationDate = creationDate;
        this.completed    = completed;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long          id;
    private final String        title;
    private final String        description;
    private final LocalDateTime creationDate;
    private boolean       completed;

    public static TaskEntity fromDomainModel(Task task) {
        return new TaskEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreationDate(),
                task.isCompleted()
        );
    }

    public Task toDomainModel() {
        return new Task(
                id,
                title,
                description,
                creationDate,
                completed
        );
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public boolean isCompleted() {
        return completed;
    }
}
