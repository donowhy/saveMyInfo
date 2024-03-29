package com.gathering.info.info.domain.users.controller;

import com.gathering.info.info.domain.users.dto.serviceDTO.Register;
import com.gathering.info.info.domain.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/register")
    public ResponseEntity<Long> register (@RequestBody Register register) {
        Long id = usersService.registerUser(register);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
}
