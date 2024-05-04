package com.gathering.info.info.domain.resumes.repository;

import com.gathering.info.info.domain.resumes.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
