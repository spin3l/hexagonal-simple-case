package com.spinel.hexagonal.domain.ports.in;

import com.spinel.hexagonal.domain.models.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
