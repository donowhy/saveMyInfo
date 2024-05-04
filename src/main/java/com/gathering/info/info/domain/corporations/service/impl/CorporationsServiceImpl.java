package com.gathering.info.info.domain.corporations.service.impl;

import com.gathering.info.info.domain.corporations.service.CorporationService;
//import com.gathering.info.info.domain.corporations.service.TasksService;
import com.gathering.info.info.domain.corporations.service.dto.RegisterCorporation;
import com.gathering.info.info.domain.corporations.entity.Corporation;
import com.gathering.info.info.domain.corporations.repository.CorporationsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CorporationsServiceImpl implements CorporationService {

    private final CorporationsRepository corporationsRepository;

    @Override
    public void registerCorp(RegisterCorporation registerCorporation) {

        Corporation corporation = Corporation.builder()
                .name(registerCorporation.name())
                .startDate(registerCorporation.startDate())
                .endDate(registerCorporation.endDate())
                .build();

        corporationsRepository.save(corporation);
    }
}
