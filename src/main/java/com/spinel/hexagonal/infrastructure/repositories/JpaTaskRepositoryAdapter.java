package com.spinel.hexagonal.infrastructure.repositories;

import com.spinel.hexagonal.domain.models.Task;
import com.spinel.hexagonal.domain.ports.out.TaskRepositoryPort;
import com.spinel.hexagonal.infrastructure.entities.TaskEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository jpaTaskRepository;

    public JpaTaskRepositoryAdapter(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity      = TaskEntity.fromDomainModel(task);
        TaskEntity savedTaskEntity = jpaTaskRepository.save(taskEntity);
        return savedTaskEntity.toDomainModel();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRepository
                .findById(id)
                .map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository
                .findAll()
                .stream()
                .map(TaskEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Task> update(Task task) {
        if (!jpaTaskRepository.existsById(task.getId())) {
            return Optional.empty();
        }
        TaskEntity taskEntity        = TaskEntity.fromDomainModel(task);
        TaskEntity updatedTaskEntity = jpaTaskRepository.save(taskEntity);
        return Optional.of(updatedTaskEntity.toDomainModel());
    }

    @Override
    public boolean deleteById(Long id) {
        if (!jpaTaskRepository.existsById(id)) {
            return false;
        }
        jpaTaskRepository.deleteById(id);
        return true;
    }
}
