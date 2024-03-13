package com.gathering.info.info.domain.users.dto;

import com.gathering.info.info.domain.users.Jobs;
import com.gathering.info.info.domain.users.Users;
import lombok.Builder;

@Builder(toBuilder = true)
public record Register(
        String name,

        Jobs job,

        String phone,

        boolean man
) {

    public static Users of (Register register) {
        return Users.builder()
                .name(register.name())
                .job(register.job())
                .phone(register.phone())
                .man(register.man())
                .build();
    }
}
