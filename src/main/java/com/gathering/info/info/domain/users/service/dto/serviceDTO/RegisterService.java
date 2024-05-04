package com.gathering.info.info.domain.users.service.dto.serviceDTO;

import com.gathering.info.info.domain.users.entity.enumType.Jobs;
import com.gathering.info.info.domain.users.entity.Users;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Builder(toBuilder = true)
public record RegisterService(
        String nickname,

        Jobs job,

        String phone,
        String email,
        String password,

        boolean gender
) {
}
