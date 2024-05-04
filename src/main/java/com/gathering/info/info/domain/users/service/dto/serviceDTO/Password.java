package com.gathering.info.info.domain.users.service.dto.serviceDTO;

import com.gathering.info.info.domain.users.entity.Users;
import lombok.Builder;

@Builder(toBuilder = true)
public record Password (
     String originPassword,
    String changingPassword
){
}
