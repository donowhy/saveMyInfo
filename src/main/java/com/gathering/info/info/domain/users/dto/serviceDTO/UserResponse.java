package com.gathering.info.info.domain.users.dto.serviceDTO;

import com.gathering.info.info.domain.users.entity.Users;
import com.gathering.info.info.domain.users.entity.enumType.Jobs;
import lombok.Builder;

@Builder(toBuilder = true)
public record UserResponse (
      String name,
      Jobs job,
      String phone,
      boolean man
){

    public static UserResponse of (Users user) {
        return UserResponse.builder()
                .name(user.getName())
                .job(user.getJob())
                .phone(user.getPhone())
                .man(user.getMan())
                .build();
    }
}
