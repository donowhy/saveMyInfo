package com.gathering.info.info.domain.users.entity;

import com.gathering.info.info.domain.users.entity.enumType.Jobs;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(toBuilder = true)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 7)
    private String name;

    @Enumerated(EnumType.STRING)
    private Jobs job;

    @NotBlank
    @Column(length = 13, unique = true)
    private String phone;

    @NotNull
    private Boolean man;
}
