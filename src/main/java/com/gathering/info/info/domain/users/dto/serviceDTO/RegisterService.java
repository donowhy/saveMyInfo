package com.gathering.info.info.domain.users.dto.serviceDTO;

import com.gathering.info.info.domain.users.entity.enumType.Jobs;
import com.gathering.info.info.domain.users.entity.Users;
import lombok.Builder;

@Builder(toBuilder = true)
public record RegisterService(
        String name,

        Jobs job,

        String phone,

        boolean man
) {

    public static Users of (RegisterService registerService) {
        return Users.builder()
                .name(registerService.name())
                .job(registerService.job())
                .phone(registerService.phone())
                .man(registerService.man())
                .build();
    }
}
