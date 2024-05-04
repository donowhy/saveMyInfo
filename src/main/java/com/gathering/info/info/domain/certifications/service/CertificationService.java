package com.gathering.info.info.domain.certifications.service;

import com.gathering.info.info.domain.certifications.repository.CertificationsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CertificationService {

    private final CertificationsRepository certificationsRepository;

}
