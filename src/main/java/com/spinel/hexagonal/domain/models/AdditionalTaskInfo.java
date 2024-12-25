package com.spinel.hexagonal.domain.models;


public record AdditionalTaskInfo(
        Long userId,
        String userName,
        String userEmail
) {
}
