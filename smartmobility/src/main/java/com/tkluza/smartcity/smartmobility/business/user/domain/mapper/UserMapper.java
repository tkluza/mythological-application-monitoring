package com.tkluza.smartcity.smartmobility.business.user.domain.mapper;

import com.tkluza.smartcity.smartmobility.business.user.domain.model.UserEntity;
import com.tkluza.smartcity.smartmobility.business.user.dto.query.UserQuery;

import java.util.Objects;

public record UserMapper() {

    public UserQuery map(UserEntity entity) {
        Objects.requireNonNull(entity);

        return UserQuery.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .build();
    }
}
