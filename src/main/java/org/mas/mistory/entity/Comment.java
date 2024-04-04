package org.mas.mistory.entity;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 댓글 기본키

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // 유저 테이블과 매핑

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post; // 게시물 테이블과 매핑
}
