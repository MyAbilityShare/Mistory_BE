package org.mas.mistory.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 게시물 기본키

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // 유저 테이블과 매핑

    @Column
    private String title; // 게시물 제목

    @Column
    private String content; // 게시물 내용

    @Column(name = "board_type")
    private String boardType; // 게시물 카테고리 종류

    @Column
    private LocalDate postDate; // 게시물 게시일자

    @ColumnDefault("0")
    private Long views; // 게시물 조회수

}
