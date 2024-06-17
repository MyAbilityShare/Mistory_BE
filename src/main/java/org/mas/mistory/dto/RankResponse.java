package org.mas.mistory.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Getter
public class RankResponse {
    private String nickname;
    private LocalTime time;
    private String endTime;


    public RankResponse(String nickname, LocalTime time, LocalDateTime endTime) {
        this.nickname = nickname;
        this.time = time;
        this.endTime = endTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


}
