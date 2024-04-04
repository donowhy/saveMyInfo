package com.gathering.info.info.domain.corporations.dto;


import lombok.Builder;

@Builder(toBuilder = true)
public record RegisterTask (
        String name
){

}
