package com.gathering.info.info.domain.users;

import com.gathering.info.info.domain.users.dto.Register;
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
}
