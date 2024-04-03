package com.gathering.info.info.domain.users.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gathering.info.info.domain.users.dto.controllerDTO.Register;
import com.gathering.info.info.domain.users.entity.enumType.Jobs;
import com.gathering.info.info.domain.users.service.UsersService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = UsersController.class)
class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UsersService usersService;

    @DisplayName("이름과 전화번호, 성별을 입력하면 회원가입 로직이 호출이 된다.")
    @Test
    void register() throws Exception {
        // given
        Register register = Register.builder()
                .name("홍길동")
                .phone("010-0000-1234")
                .job(Jobs.STUDENT)
                .man(true)
                .build();

        // when
        // then
        mockMvc.perform(post("/users/register")
                .content(objectMapper.writeValueAsString(register))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isBadRequest());
    }


    @DisplayName("회원 등록 시 회원의 전화번호는 필수 입니다.")
    @Test
    void registerValidationTestAboutPhoneNumber() throws Exception {
        // given
        Register register = Register.builder()
                .name("홍길동")
                .job(Jobs.STUDENT)
                .man(true)
                .build();

        // when
        // then
        mockMvc.perform(post("/users/register")
                        .content(objectMapper.writeValueAsString(register))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }


    @DisplayName("회원 등록 시 이름은 필수 입니다.")
    @Test
    void registerValidationTestAboutName() throws Exception {
        // given
        Register register = Register.builder()
                .phone("010-0000-1234")
                .job(Jobs.STUDENT)
                .man(true)
                .build();

        // when
        // then
        mockMvc.perform(post("/users/register")
                        .content(objectMapper.writeValueAsString(register))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }


    @DisplayName("회원 등록 시 성별은 필수 입니다.")
    @Test
    void registerValidationTestAboutMan() throws Exception {
        // given
        Register register = Register.builder()
                .name("홍길동")
                .phone("010-0000-1234")
                .job(Jobs.STUDENT)
                .build();

        // when
        // then
        mockMvc.perform(post("/users/register")
                        .content(objectMapper.writeValueAsString(register))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }

    @DisplayName("회원 등록 시 직업은 필수 입니다.")
    @Test
    void registerValidationTestAboutJob() throws Exception {
        // given
        Register register = Register.builder()
                .name("홍길동")
                .phone("010-0000-1234")
                .man(true)
                .build();

        // when
        // then
        mockMvc.perform(post("/users/register")
                        .content(objectMapper.writeValueAsString(register))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }


    @DisplayName("")
    @Test
    void userInfo() {
        // given
        // when
        // then
    }

    @DisplayName("")
    @Test
    void deleteUser() {
        // given
        // when
        // then
    }
}