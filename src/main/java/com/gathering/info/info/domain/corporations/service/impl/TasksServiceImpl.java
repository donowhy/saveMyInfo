package com.gathering.info.info.domain.corporations.service.impl;

import com.gathering.info.info.domain.corporations.service.TasksService;
import com.gathering.info.info.domain.corporations.dto.RegisterTask;
import com.gathering.info.info.domain.corporations.entity.Tasks;
import com.gathering.info.info.domain.corporations.repository.TasksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TasksServiceImpl implements TasksService {

    private final TasksRepository tasksRepository;

    @Override
    public void registerTask(RegisterTask registerTask) {
        log.info("register Task = {}", tasksRepository.findAll());
        tasksRepository.save(Tasks.builder()
                .job(registerTask.name())
                .build());
    }

    @Override
    public List<Tasks> checkTask(List<String> tasks) {

        // TODO : IN 메서드로 없는 것들 추가해서 저장.
        for (String task : tasks) {
            Optional<Tasks> returnValue = tasksRepository.findByJob(task);
            if(returnValue.isEmpty()) {registerTask(new RegisterTask(task));}
        }

         return tasks.stream()
                .map(task -> Tasks.builder()
                        .job(task)
                        .build())
                .toList();
    }
}
