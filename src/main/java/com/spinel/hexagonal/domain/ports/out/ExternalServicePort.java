package com.spinel.hexagonal.domain.ports.out;

import com.spinel.hexagonal.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);

}
