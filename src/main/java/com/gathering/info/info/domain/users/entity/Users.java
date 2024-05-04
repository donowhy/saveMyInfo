package com.gathering.info.info.domain.users.entity;

import com.gathering.info.info.domain.users.entity.enumType.Jobs;
import com.gathering.info.info.util.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(toBuilder = true)
public class Users extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 7)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Jobs job;

    @Column(length = 25, unique = true)
    private String email;

    @NotBlank
    @Column(length = 200)
    private String password;

    @NotBlank
    @Column(length = 13, unique = true)
    private String phone;

    @NotNull
    private Boolean gender;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserInfo(String email, String nickname, String phone) {
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
    }
}
