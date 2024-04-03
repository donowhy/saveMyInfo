package com.gathering.info.info.domain.users.controller;

import com.gathering.info.info.domain.users.dto.controllerDTO.Register;
import com.gathering.info.info.domain.users.dto.serviceDTO.UserResponse;
import com.gathering.info.info.domain.users.service.UsersService;
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

    private final UsersService usersService;

    @PostMapping("/register")
    public ResponseEntity<Long> register (@Valid @RequestBody Register register) {
        Long id = usersService.registerUser(register.toServiceRequest());
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<UserResponse> userInfo (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(usersService.getUserInfo(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable Long id) {
        usersService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
