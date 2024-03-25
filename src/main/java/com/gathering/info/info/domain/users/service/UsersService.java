package com.gathering.info.info.domain.users.service;

import com.gathering.info.info.domain.users.dto.serviceDTO.Register;
import com.gathering.info.info.domain.users.dto.serviceDTO.UserResponse;
import com.gathering.info.info.domain.users.entity.Users;
import com.gathering.info.info.domain.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    // 저장
    public void registerUser (Register register) {
        usersRepository.save(Register.of(register));
    }

    // 단건 조회
    public UserResponse getUserInfo (Long id){
        Users user = usersRepository.findById(id).
                orElseThrow(IllegalArgumentException::new);

        return UserResponse.of(user);
    }

    // 사용자 삭제
    public void deleteUser(Long id) {
        Users user = usersRepository.findById(id).
                orElseThrow(IllegalArgumentException::new);

        usersRepository.delete(user);
    }
}
