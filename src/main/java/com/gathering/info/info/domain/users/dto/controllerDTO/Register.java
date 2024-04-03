package com.gathering.info.info.domain.users.dto.controllerDTO;

import com.gathering.info.info.domain.users.dto.serviceDTO.RegisterService;
import com.gathering.info.info.domain.users.entity.Users;
import com.gathering.info.info.domain.users.entity.enumType.Jobs;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder(toBuilder = true)
public record Register(

        @NotNull(message = "이름은 필수 입력 값입니다.")
        String name,

        @NotNull(message = "직업은 필수 입력 값입니다.")
        Jobs job,

        @NotNull(message = "전화번호는 필수 입력 값입니다.")
        String phone,

        @NotNull(message = "성별은 필수 입력 값입니다.")
        boolean man
) {

    public RegisterService toServiceRequest() {
        return RegisterService.builder()
                .name(name)
                .job(job)
                .phone(phone)
                .man(man)
                .build();
    }
}
