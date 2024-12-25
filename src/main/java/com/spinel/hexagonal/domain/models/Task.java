package com.spinel.hexagonal.domain.models;

import java.time.LocalDateTime;

public class Task {
    private Long          id;
    private String        title;
    private String        description;
    private LocalDateTime creationDate;
    private boolean       completed;

    public Task(
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
