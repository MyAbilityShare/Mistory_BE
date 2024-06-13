package org.mas.mistory.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class GuestBook {

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

}

