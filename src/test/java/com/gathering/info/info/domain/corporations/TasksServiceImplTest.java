package com.gathering.info.info.domain.corporations;

import com.gathering.info.info.domain.corporations.dto.RegisterTask;
import com.gathering.info.info.domain.corporations.entity.Tasks;
import com.gathering.info.info.domain.corporations.repository.TasksRepository;
import com.gathering.info.info.domain.corporations.service.impl.TasksServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TasksServiceImplTest {

    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private TasksServiceImpl tasksService;

    @AfterEach
    void tearDown() {
        tasksRepository.deleteAllInBatch();
    }

    @DisplayName("직무의 이름으로 직무를 저장한다.")
    @Test
    void returnTasksWhenInputJobName() {
        // given
        RegisterTask job = RegisterTask.builder()
                .name("JOB1")
                .build();

        // when
        tasksService.registerTask(job);

        // then
        List<Tasks> all = tasksRepository.findAll();
        assertThat(all.get(0).getJob()).isEqualTo("JOB1");
    }

    @DisplayName("등록시 직무의 이름이 저장되어있지 않으면, 저장해서 반환한다.")
    @Test
    void checkTask() {
        // given
        Tasks.create("JOB1");
        Tasks.create("JOB2");
        Tasks.create("JOB3");

        List<String> tasks = List.of("JOB1", "JOB2", "JOB3", "JOB4");

        // when
        tasksService.checkTask(tasks);

        // then
        List<Tasks> tasksList = tasksRepository.findAll();
        assertThat(tasksList.size()).isEqualTo(4);
        assertThat(tasksList.get(3).getJob()).isEqualTo("JOB4");
    }
}