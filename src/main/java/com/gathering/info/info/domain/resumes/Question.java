package com.gathering.info.info.domain.resumes;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(toBuilder = true)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionItem;

    private String answerItem;

    @ManyToOne(fetch = FetchType.LAZY)
    private Resume resume;
}
