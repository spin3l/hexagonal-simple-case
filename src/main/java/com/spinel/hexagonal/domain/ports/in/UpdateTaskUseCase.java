package com.spinel.hexagonal.domain.ports.in;

import com.spinel.hexagonal.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task task);
}
