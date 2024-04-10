package com.gathering.info.info.domain.corporations;

import com.gathering.info.info.domain.corporations.dto.RegisterCorporation;
import com.gathering.info.info.domain.corporations.entity.Corporation;
import com.gathering.info.info.domain.corporations.entity.Task;
import com.gathering.info.info.domain.corporations.repository.CorporationsRepository;
import com.gathering.info.info.domain.corporations.repository.TasksRepository;
import com.gathering.info.info.domain.corporations.service.impl.CorporationsServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;


@SpringBootTest
class CorporationsServiceImplTest {

    @Autowired
    private CorporationsRepository corporationsRepository;

    @Autowired
    private CorporationsServiceImpl corporationsService;

    @Autowired
    private TasksRepository tasksRepository;

    @AfterEach
    void tearDown() {
        corporationsRepository.deleteAllInBatch();
        tasksRepository.deleteAllInBatch();
    }

    @DisplayName("회사 등록 시 필요한 정보가 모두 저장되는지 검증한다.")
    @Test
    @Transactional
    void registerCorporation() {
        // given
        List<String> jobList = List.of("JOB1", "JOB2", "JOB3");

        RegisterCorporation registerCorporation = RegisterCorporation.builder()
                .name("구글")
                .startDate(LocalDateTime.of(2024, 4, 30, 12, 30))
                .endDate(LocalDateTime.of(2024, 5, 30, 12, 30))
                .tasksList(jobList)
                .build();

        // when
        corporationsService.registerCorp(registerCorporation);

        // then
        List<Corporation> corporationsList = corporationsRepository.findAll();
        assertThat(corporationsList)
                .extracting("name", "startDate", "endDate")
                .containsExactlyInAnyOrder(
                        tuple("구글",
                                LocalDateTime.of(2024, 4, 30, 12, 30),
                                LocalDateTime.of(2024, 5, 30, 12, 30)));

        List<String> storedJobs = corporationsList.get(0).getTaskList().stream()
                .map(Task::getJob)
                .collect(Collectors.toList());
        assertThat(storedJobs).containsExactlyInAnyOrderElementsOf(jobList);
    }
}