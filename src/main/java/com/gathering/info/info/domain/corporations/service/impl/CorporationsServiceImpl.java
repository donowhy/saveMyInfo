package com.gathering.info.info.domain.corporations.service.impl;

import com.gathering.info.info.domain.corporations.service.CorporationService;
import com.gathering.info.info.domain.corporations.service.TasksService;
import com.gathering.info.info.domain.corporations.dto.RegisterCorporation;
import com.gathering.info.info.domain.corporations.entity.Corporations;
import com.gathering.info.info.domain.corporations.entity.Tasks;
import com.gathering.info.info.domain.corporations.repository.CorporationsRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CorporationsServiceImpl implements CorporationService {

    private final CorporationsRepository corporationsRepository;
    private final TasksService tasksService;

    @Override
    public void registerCorp(RegisterCorporation registerCorporation) {
        List<Tasks> tasksList = tasksService.checkTask(registerCorporation.tasksList());
        corporationsRepository.save(Corporations.toRegister(tasksList, registerCorporation));
    }
}
