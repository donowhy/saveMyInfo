package com.gathering.info.info.domain.users.repository;

import com.gathering.info.info.domain.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findUsersByEmail(String email);
}
