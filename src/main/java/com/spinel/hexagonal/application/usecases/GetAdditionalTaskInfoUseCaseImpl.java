package com.spinel.hexagonal.application.usecases;

import com.spinel.hexagonal.domain.models.AdditionalTaskInfo;
import com.spinel.hexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.spinel.hexagonal.domain.ports.out.ExternalServicePort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort externalServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        return externalServicePort.getAdditionalTaskInfo(taskId);
    }
}
