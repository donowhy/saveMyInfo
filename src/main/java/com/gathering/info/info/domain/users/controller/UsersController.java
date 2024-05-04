package com.gathering.info.info.domain.users.controller;

import com.gathering.info.info.domain.users.service.dto.AccessToken;
import com.gathering.info.info.domain.users.service.dto.LoginInfo;
import com.gathering.info.info.domain.users.service.dto.controllerDTO.Register;
import com.gathering.info.info.domain.users.service.dto.serviceDTO.Password;
import com.gathering.info.info.domain.users.service.dto.serviceDTO.UserInfoChange;
import com.gathering.info.info.domain.users.service.dto.serviceDTO.UserResponse;
import com.gathering.info.info.domain.users.service.impl.UserServiceImpl;
import com.gathering.info.info.util.UserInfo;
import com.gathering.info.info.util.UsersInfo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<Long> register (@Valid @RequestBody Register register) {
        userServiceImpl.registerUser(register.toServiceRequest());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/info")
    public ResponseEntity<UserResponse> userInfo (@UserInfo UsersInfo usersInfo) {
        return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.getUserInfo(usersInfo.getId()));
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteUser (@UserInfo UsersInfo usersInfo) {
        userServiceImpl.deleteUser(usersInfo.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AccessToken> login (@Valid @RequestBody LoginInfo loginInfo) {
        return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.login(loginInfo));
    }

    @PutMapping("/password")
    public ResponseEntity<Void> updateUserPassword (@Valid @RequestBody Password password,
                                                    @UserInfo UsersInfo usersInfo) {
        userServiceImpl.updateUserPassword(password, usersInfo.getId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/info/change")
    public ResponseEntity<Void> updateUserInfo(@Valid @RequestBody UserInfoChange userInfo,
                                               @UserInfo UsersInfo usersInfo) {
        userServiceImpl.updateUserInfo(userInfo, usersInfo.getId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
