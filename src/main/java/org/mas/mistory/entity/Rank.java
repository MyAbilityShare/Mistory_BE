package org.mas.mistory.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ranking")
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rank_id")
    private Long id;

    private String nickname; // 닉네임
    private LocalTime time; // 소요시간

    @Column(name = "end_time")
    private LocalDateTime endTime; // 게임 종료시간
}
