package com.spinel.hexagonal.application.usecases;

import com.spinel.hexagonal.domain.models.Task;
import com.spinel.hexagonal.domain.ports.in.CreateTaskUseCase;
import com.spinel.hexagonal.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
