package com.gathering.info.info.domain.resumes.entity;

import com.gathering.info.info.domain.corporations.entity.Corporation;
import com.gathering.info.info.domain.question.entity.Question;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(toBuilder = true)
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Corporation corporation;

    @Builder.Default
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<Question> questionList = new ArrayList<>();
}
