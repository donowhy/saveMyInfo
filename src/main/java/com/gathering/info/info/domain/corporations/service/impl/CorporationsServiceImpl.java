package com.gathering.info.info.domain.corporations.service.impl;

import com.gathering.info.info.domain.corporations.repository.TasksRepository;
import com.gathering.info.info.domain.corporations.service.CorporationService;
//import com.gathering.info.info.domain.corporations.service.TasksService;
import com.gathering.info.info.domain.corporations.dto.RegisterCorporation;
import com.gathering.info.info.domain.corporations.entity.Corporation;
import com.gathering.info.info.domain.corporations.entity.Task;
import com.gathering.info.info.domain.corporations.repository.CorporationsRepository;
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
    private final TasksRepository tasksRepository;
    @Override
    public void registerCorp(RegisterCorporation registerCorporation) {
//        List<Task> taskList = tasksService.checkTask(registerCorporation.tasksList());
//        corporationsRepository.save(Corporation.toRegister(taskList, registerCorporation));
        List<Task> tasks = registerCorporation.tasksList().stream()
                .map(task -> Task.builder()
                        .job(task)
                        .build())
                .toList();

        tasksRepository.saveAll(tasks);

        Corporation corporation = Corporation.builder()
                .name(registerCorporation.name())
                .startDate(registerCorporation.startDate())
                .endDate(registerCorporation.endDate())
                .taskList(tasks)
                .build();

        corporationsRepository.save(corporation);
    }
}
