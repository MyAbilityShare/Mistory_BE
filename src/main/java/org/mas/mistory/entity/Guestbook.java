package org.mas.mistory.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Guestbook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guestbook_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Major major;

    private String name;

    private String content;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public Guestbook(Major major, String name, String content, LocalDateTime createdAt) {
        this.major = major;
        this.name = name;
        this.content = content;
        this.createdAt = createdAt;
    }

}

