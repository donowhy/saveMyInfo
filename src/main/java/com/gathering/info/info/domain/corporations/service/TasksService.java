package com.gathering.info.info.domain.corporations.service;

import com.gathering.info.info.domain.corporations.dto.RegisterTask;
import com.gathering.info.info.domain.corporations.entity.Tasks;

import java.util.List;

public interface TasksService {

    void registerTask (RegisterTask registerTask);
    List<Tasks> checkTask (List<String> tasks);
}
