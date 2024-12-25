package com.spinel.hexagonal.domain.ports.in;

import com.spinel.hexagonal.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {
    List<Task> getAllTasks();
    Optional<Task> getTaskById(Long id);
}
