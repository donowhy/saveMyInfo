package com.gathering.info.info.domain.users.service;

import com.gathering.info.info.domain.users.dto.serviceDTO.RegisterService;
import com.gathering.info.info.domain.users.dto.serviceDTO.UserResponse;
import com.gathering.info.info.domain.users.entity.Users;
import com.gathering.info.info.domain.users.entity.enumType.Jobs;
import com.gathering.info.info.domain.users.repository.UsersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class UsersServiceTest {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersRepository usersRepository;

    @AfterEach
    void tearDown() {
        usersRepository.deleteAllInBatch();
    }

    @DisplayName("사용자의 이름, 직업, 성별, 휴대폰 번호를 입력하면 아이디를 생성할 수 있다.")
    @Test
    void registerUser() {
        //given
        RegisterService registerService = new RegisterService("name", Jobs.STUDENT, "010-0000-0000", true);

        //when
        usersService.registerUser(registerService);
        List<Users> users = usersRepository.findAll();

        //then
        assertThat(users).hasSize(1)
                .extracting( "name", "job", "phone", "man")
                .containsExactlyInAnyOrder(
                        tuple("name", Jobs.STUDENT, "010-0000-0000", true));
    }

    @DisplayName("사용자를 저장할 때 같은 전화번호로 저장하면 에러가 발생한다.")
    @Test
    void phoneNumberDuplicatedError() {
        //given
        RegisterService registerService1 = RegisterService.builder()
                .name("name1")
                .job(Jobs.STUDENT)
                .phone("010-0000-0000")
                .man(true)
                .build();

        RegisterService registerService2 = RegisterService.builder()
                .name("name2")
                .job(Jobs.FINDER)
                .phone("010-0000-0000")
                .man(true)
                .build();
        //when //then
        usersService.registerUser(registerService1);
        assertThatThrownBy(() -> usersService.registerUser(registerService2))
                .isInstanceOf(DataIntegrityViolationException.class);
    }

    @DisplayName("사용자 저장 시 이름이 7글자 초과시 에러가 발생한다.")
    @Test
    void nameLengthIsTooLongError() {
        //given
        RegisterService registerService = RegisterService.builder()
                .name("mynameisKang")
                .job(Jobs.STUDENT)
                .phone("010-0000-0000")
                .man(true)
                .build();

        //when //then
        assertThatThrownBy(() -> usersService.registerUser(registerService))
                .isInstanceOf(DataIntegrityViolationException.class);
    }

    @DisplayName("사용자 전화번호 저장 시 13글자를 넘으면 에러를 발생한다.")
    @Test
    void phoneLengthIsTooLongError() {
        //given
        RegisterService registerService = RegisterService.builder()
                .name("mynameisKang")
                .job(Jobs.STUDENT)
                .phone("010-0000-0000")
                .man(true)
                .build();

        //when //then
        assertThatThrownBy(() -> usersService.registerUser(registerService))
                .isInstanceOf(DataIntegrityViolationException.class);
    }

    @DisplayName("사용자를 조회하면 사용자의 이름, 직업, 전화번호, 성별을 조회한다.")
    @Test
    void getUserInfo() {
        //given
        RegisterService registerService = RegisterService.builder()
                .name("name")
                .job(Jobs.STUDENT)
                .phone("010-0000-0000")
                .man(true)
                .build();
        Long id = usersService.registerUser(registerService);

        //when
        UserResponse userInfo = usersService.getUserInfo(id);

        // then
        assertThat(userInfo.name()).isEqualTo("name");
        assertThat(userInfo.job()).isEqualTo(Jobs.STUDENT);
        assertThat(userInfo.phone()).isEqualTo("010-0000-0000");
        assertThat(userInfo.man()).isEqualTo(true);
    }

    @DisplayName("사용자의 Id 값으로 삭제할 수 있다.")
    @Test
    void deleteUser() {
        //given
        RegisterService registerService = RegisterService.builder()
                .name("name")
                .job(Jobs.STUDENT)
                .phone("010-0000-0000")
                .man(true)
                .build();
        Long id = usersService.registerUser(registerService);

        //when
        usersService.deleteUser(id);
        List<Users> users = usersRepository.findAll();

        // then
        assertThat(users).hasSize(0);
    }
}