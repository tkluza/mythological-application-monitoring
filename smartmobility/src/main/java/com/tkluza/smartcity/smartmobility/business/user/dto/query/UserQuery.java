package com.tkluza.smartcity.smartmobility.business.user.dto.query;

import lombok.Builder;

@Builder
public record UserQuery(
        Long id,
        String firstName,
        String lastName,
        String email
) {

}
