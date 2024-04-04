package com.gathering.info.info.domain.corporations.dto;


import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder(toBuilder = true)
public record RegisterCorporation (
        String name,
        LocalDateTime startDate,
        LocalDateTime endDate,
        List<String> tasksList
){
}
