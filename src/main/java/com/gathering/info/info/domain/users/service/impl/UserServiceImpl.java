package com.gathering.info.info.domain.users.service.impl;

import com.gathering.info.info.domain.users.service.dto.AccessToken;
import com.gathering.info.info.domain.users.service.dto.LoginInfo;
import com.gathering.info.info.domain.users.service.dto.serviceDTO.Password;
import com.gathering.info.info.domain.users.service.dto.serviceDTO.RegisterService;
import com.gathering.info.info.domain.users.service.dto.serviceDTO.UserInfoChange;
import com.gathering.info.info.domain.users.service.dto.serviceDTO.UserResponse;
import com.gathering.info.info.domain.users.entity.Users;
import com.gathering.info.info.domain.users.repository.UsersRepository;
import com.gathering.info.info.domain.users.service.UserService;
import com.gathering.info.info.util.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    // 저장
    @Override
    public void registerUser (RegisterService registerService) {

        Users user = Users.builder()
                .email(registerService.email())
                .password(passwordEncoder.encode(registerService.password()))
                .nickname(registerService.nickname())
                .job(registerService.job())
                .phone(registerService.phone())
                .gender(registerService.gender())
                .build();

        usersRepository.save(user);
    }

    // 단건 조회
    @Override
    public UserResponse getUserInfo (Long id){
        Users user = usersRepository.findById(id)
                        .orElseThrow(IllegalArgumentException::new);

        return UserResponse.of(user);
    }

    // 사용자 삭제
    @Override
    public void deleteUser(Long id) {
        Users user = usersRepository.findById(id)
                        .orElseThrow(IllegalArgumentException::new);

        usersRepository.delete(user);
    }

    // 로그인
    @Override
    public AccessToken login(LoginInfo loginInfo) {
        Users user = usersRepository.findUsersByEmail(loginInfo.email())
                .orElseThrow(IllegalAccessError::new);

        boolean verified = passwordEncoder.matches(loginInfo.password(), user.getPassword());
        if(!verified) {
            throw new Error();
        }

        String accessToken = jwtProvider.createAccessToken(user);
        String refreshToken = jwtProvider.createRefreshToken(user);
        return new AccessToken(accessToken);
    }

    @Override
    public void updateUserPassword(Password password, Long id) {
        Users user = usersRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        boolean verified = passwordEncoder.matches(password.originPassword(), user.getPassword());
        if(!verified) {
            throw new Error();
        }

        user.setPassword(password.changingPassword());

    }

    @Override
    public void updateUserInfo(UserInfoChange userInfoChange, Long id) {
        Users user = usersRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        user.setUserInfo(userInfoChange.email(), userInfoChange.nickname(), userInfoChange.phone());
    }

    @Override
    public AccessToken freshToken(Long id) {
        Users user = usersRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        String accessToken = jwtProvider.createAccessToken(user);
        String refreshToken = jwtProvider.createRefreshToken(user);
        return new AccessToken(accessToken);
    }

}
