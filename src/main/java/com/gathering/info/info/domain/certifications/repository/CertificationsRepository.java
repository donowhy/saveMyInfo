package com.gathering.info.info.domain.certifications.repository;

import com.gathering.info.info.domain.certifications.entity.Certifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationsRepository extends JpaRepository<Certifications, Long> {
}
