package com.gathering.info.info.domain.corporations.repository;

import com.gathering.info.info.domain.corporations.entity.Corporations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporationsRepository extends JpaRepository<Corporations, Long> {
}
