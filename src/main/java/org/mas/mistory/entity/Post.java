package org.mas.mistory.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    @Column
    private String title; // 게시물 제목

    @Column
    private String content; // 게시물 내용

    @Enumerated(EnumType.STRING)
    @Column(name = "board_type")
    private BoardType boardType; // 게시물 카테고리 종류

    @Column
    private LocalDate postDate; // 게시물 게시일자

    @Builder
    public Post(Member member, String title, String content, BoardType boardType, LocalDate postDate, Long views) {
        this.member = member;
        this.title = title;
        this.content = content;
        this.boardType = boardType;
        this.postDate = postDate;
    }

}
