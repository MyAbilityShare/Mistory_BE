package org.mas.mistory.dto;

import lombok.Getter;
import org.mas.mistory.entity.Rank;

import java.time.*;
import java.time.format.DateTimeFormatter;

@Getter
public class RankResponse {
    private String nickname;
    private LocalTime time;
    private String endTime;


    public RankResponse(String nickname, LocalTime time, LocalDateTime endTime) {
        this.nickname = nickname;
        this.time = time;
        ZonedDateTime koreaEndTime = endTime.atZone(ZoneId.of("Asia/Seoul"));
        this.endTime = koreaEndTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
