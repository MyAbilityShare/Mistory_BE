package org.mas.mistory.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String username; // 로그인 시 사용하는 id

    @Column(name = "user_pw", nullable = false, unique = true)
    private String password; // 비밀번호

    @Column(name = "user_name")
    private String nickname; // 유저 이름

    @Enumerated(EnumType.STRING)
    private Role role;
}
