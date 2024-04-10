//package com.gathering.info.info.domain.corporations;
//
//import com.gathering.info.info.domain.corporations.dto.RegisterTask;
//import com.gathering.info.info.domain.corporations.entity.Task;
//import com.gathering.info.info.domain.corporations.repository.TasksRepository;
//import com.gathering.info.info.domain.corporations.service.impl.TasksServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@SpringBootTest
//class TaskServiceImplTest {
//
//    @Autowired
//    private TasksRepository tasksRepository;
//
//    @Autowired
//    private TasksServiceImpl tasksService;
//
//    @AfterEach
//    void tearDown() {
//        tasksRepository.deleteAllInBatch();
//    }
//
//    @DisplayName("직무의 이름으로 직무를 저장한다.")
//    @Test
//    void returnTasksWhenInputJobName() {
//        // given
//        RegisterTask job = RegisterTask.builder()
//                .name("JOB1")
//                .build();
//
//        // when
//        tasksService.registerTask(job);
//
//        // then
//        List<Task> all = tasksRepository.findAll();
//        assertThat(all.get(0).getJob()).isEqualTo("JOB1");
//    }
//
//    @DisplayName("등록시 직무의 이름이 저장되어있지 않으면, 저장해서 반환한다.")
//    @Test
//    void checkTask() {
//        // given
//        Task.create("JOB1");
//        Task.create("JOB2");
//        Task.create("JOB3");
//
//        List<String> tasks = List.of("JOB1", "JOB2", "JOB3", "JOB4");
//
//        // when
//        tasksService.checkTask(tasks);
//
//        // then
//        List<Task> taskList = tasksRepository.findAll();
//        assertThat(taskList.size()).isEqualTo(4);
//        assertThat(taskList.get(3).getJob()).isEqualTo("JOB4");
//    }
//}