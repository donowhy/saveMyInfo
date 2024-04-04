package com.gathering.info.info.domain.corporations.repository;

import com.gathering.info.info.domain.corporations.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
    Optional<Tasks> findByJob(String job);
}
