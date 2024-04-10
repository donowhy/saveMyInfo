package com.gathering.info.info.domain.resumes.dto;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record RegisterResume (
        Long corporationId,
        List<RegisterQuestion> registerQuestions
) {

}
