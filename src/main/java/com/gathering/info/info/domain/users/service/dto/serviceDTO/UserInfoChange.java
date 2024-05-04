package com.gathering.info.info.domain.users.service.dto.serviceDTO;

import lombok.Builder;

@Builder(toBuilder = true)
public record UserInfoChange(
    String nickname,
    String phone,
    String email
) {
}
