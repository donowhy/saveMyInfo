package com.gathering.info.info.domain.corporations.service.dto;


import lombok.Builder;

@Builder(toBuilder = true)
public record RegisterTask (
        String name
){

}
