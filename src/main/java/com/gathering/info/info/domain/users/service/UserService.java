package com.gathering.info.info.domain.users.service;

import com.gathering.info.info.domain.users.service.dto.AccessToken;
import com.gathering.info.info.domain.users.service.dto.LoginInfo;
import com.gathering.info.info.domain.users.service.dto.serviceDTO.Password;
import com.gathering.info.info.domain.users.service.dto.serviceDTO.UserInfoChange;
import com.gathering.info.info.domain.users.service.dto.serviceDTO.RegisterService;
import com.gathering.info.info.domain.users.service.dto.serviceDTO.UserResponse;

import java.security.NoSuchAlgorithmException;

public interface UserService {

    // 저장
    void registerUser (RegisterService registerService);

    // 단건 조회
    UserResponse getUserInfo (Long id);

    // 사용자 삭제
    void deleteUser(Long id);

    // 로그인
    AccessToken login (LoginInfo loginInfo);

    // 패스워드 변경
    void updateUserPassword(Password password, Long id) throws IllegalAccessException, NoSuchAlgorithmException;

    // 이름, 닉네임 변경
    void updateUserInfo(UserInfoChange userInfoChange, Long id);

    AccessToken freshToken (Long id);

}
