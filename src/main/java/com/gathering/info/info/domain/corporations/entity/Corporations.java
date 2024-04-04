package com.gathering.info.info.domain.corporations.entity;

import com.gathering.info.info.domain.corporations.dto.RegisterCorporation;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@AllArgsConstructor
@Builder(toBuilder = true)
public class Corporations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tasks> tasksList;

    public static Corporations toRegister(List<Tasks> tasks, RegisterCorporation registerCorporation) {

        return Corporations.builder()
                .name(registerCorporation.name())
                .startDate(registerCorporation.startDate())
                .endDate(registerCorporation.endDate())
                .tasksList(tasks)
                .build();
    }
}
