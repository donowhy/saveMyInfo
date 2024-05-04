package com.gathering.info.info.domain.certifications.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(toBuilder = true)
public class Certifications {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certificationId;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String provider;

    private LocalDateTime acquisitedTime;

    private LocalDateTime expiredTime;
}
