package org.mas.mistory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mas.mistory.entity.Rank;

import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RankRequest {
    private String nickname;
    private LocalTime time;

//    public Rank toEntity() {
//        return new Rank(nickname, time, endTime);
//    }
}
