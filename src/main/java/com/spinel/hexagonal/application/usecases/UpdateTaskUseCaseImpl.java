package com.spinel.hexagonal.application.usecases;

import com.spinel.hexagonal.domain.models.Task;
import com.spinel.hexagonal.domain.ports.in.UpdateTaskUseCase;
import com.spinel.hexagonal.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(
            Long id,
            Task task
    ) {
        return taskRepositoryPort.update(task);
    }
}
