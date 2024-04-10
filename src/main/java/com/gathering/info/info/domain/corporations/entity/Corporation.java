package com.gathering.info.info.domain.corporations.entity;

import com.gathering.info.info.domain.corporations.dto.RegisterCorporation;
import com.gathering.info.info.domain.resumes.Resume;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@AllArgsConstructor
@Builder(toBuilder = true)
public class Corporation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> taskList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corporation", orphanRemoval = true)
    private List<Resume> resumeList = new ArrayList<>();

}
