package com.gathering.info.info.domain.resumes.dto;

import lombok.Builder;

@Builder(toBuilder = true)
public record RegisterQuestion (
        String questionItem,
        String answerItem
){
}
