//package com.gathering.info.info.domain.corporations;
//
//import com.gathering.info.info.domain.corporations.entity.Task;
//import com.gathering.info.info.domain.corporations.repository.TasksRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@SpringBootTest
//class TaskRepositoryTest {
//
//    @Autowired
//    private TasksRepository tasksRepository;
//
//    @AfterEach
//    void tearDown() {
//        tasksRepository.deleteAllInBatch();
//    }
//
//    @DisplayName("직무의 이름으로 조회시 해당 직무를 반환한다.")
//    @Test
//    void returnTasksWhenInputJobName() {
//        // given
//        Task tasks1 = Task.create("JOB1");
//        tasksRepository.save(tasks1);
//
//        // when
//        Task tasks = tasksRepository.findByJob("JOB1")
//                .orElseThrow(RuntimeException::new);
//
//        // then
//        assertThat(tasks.getJob()).isEqualTo("JOB1");
//    }
//
//    @DisplayName("직무의 이름이 없을시 RunTimeException을 반환한다.")
//    @Test
//    void occurredRuntimeExceptionWhenNotInJob() {
//        // given
//        Task tasks1 = Task.create("JOB1");
//        tasksRepository.save(tasks1);
//
//        // when then
//        assertThatThrownBy(() -> tasksRepository.findByJob("JOB2")
//                        .orElseThrow(RuntimeException::new))
//                .isInstanceOf(RuntimeException.class);
//    }
//}