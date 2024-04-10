package com.gathering.info.info.domain.resumes;

import com.gathering.info.info.domain.corporations.dto.RegisterCorporation;
import com.gathering.info.info.domain.corporations.entity.Corporation;
import com.gathering.info.info.domain.corporations.repository.CorporationsRepository;
import com.gathering.info.info.domain.corporations.repository.TasksRepository;
import com.gathering.info.info.domain.corporations.service.CorporationService;
import com.gathering.info.info.domain.resumes.dto.RegisterQuestion;
import com.gathering.info.info.domain.resumes.dto.RegisterResume;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResumeServiceImplTest {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private CorporationsRepository corporationsRepository;

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private CorporationService corporationService;

    @AfterEach
    void tearDown() {
        corporationsRepository.deleteAll();
    }



    @Test
    @Transactional
    void registerResume() {
        // given
        List<String> jobList = List.of("JOB4");

        RegisterCorporation registerCorporation = RegisterCorporation.builder()
                .name("구글")
                .startDate(LocalDateTime.of(2024, 4, 30, 12, 30))
                .endDate(LocalDateTime.of(2024, 5, 30, 12, 30))
                .tasksList(jobList)
                .build();

        corporationService.registerCorp(registerCorporation);

        List<Corporation> corporationsList = corporationsRepository.findAll();
        System.out.println(corporationsList.size() + "corporationsList.size()");
        RegisterQuestion question1 = new RegisterQuestion("첫 번째 질문", "첫 번째 대답");
        RegisterQuestion question2 = new RegisterQuestion("두 번째 질문", "두 번째 대답");

        List<RegisterQuestion> questionList = Arrays.asList(question1, question2);
        RegisterResume registerResume = new RegisterResume(corporationsList.get(0).getId(), questionList);

        // when
        resumeService.registerResume(registerResume);

        // then
        List<Resume> all = resumeRepository.findAll();
        Resume resume = all.get(0);
        assertEquals(corporationsList.get(0).getId(), resume.getCorporation().getId());
        assertEquals(2, resume.getQuestionList().size());
        assertEquals("첫 번째 질문", resume.getQuestionList().get(0).getQuestionItem());
    }
}