package org.mas.mistory.service;

import lombok.RequiredArgsConstructor;
import org.mas.mistory.dto.RankRequest;
import org.mas.mistory.dto.RankResponse;
import org.mas.mistory.entity.Rank;
import org.mas.mistory.repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RankService {

    private final RankRepository rankRepository;

    // 새로운 기록과 사용자를 저장하는 메서드
//    public Rank saveRank(RankRequest rankRequest) {
//        LocalDateTime endTime = LocalDateTime.now();
//        Rank rank = new Rank(rankRequest.getNickname(), rankRequest.getTime(), endTime);
//        return rankRepository.save(rank);
//    }

    public Rank saveRank(String nickname, LocalTime time) {
        LocalDateTime endTime = LocalDateTime.now();
        Rank rank = new Rank(nickname, time, endTime);
        return rankRepository.save(rank);
    }

    // 시간이 적게 걸린 순서대로 return
    /* public List<RankResponse> getAllRanks() {
        List<Rank> ranks = rankRepository.findAll(Sort.by(Sort.Direction.ASC, "time"));
        return ranks.stream()
                .map(rank -> new RankResponse(
                        rank.getNickname(),
                        rank.getTime(),
                        rank.getEndTime()
                ))
                .collect(Collectors.toList());
    } */

    /* public List<RankResponse> getAllRanks(RankRequest request) {
        saveRank(request);
        List<Rank> ranks = rankRepository.findAll(Sort.by(Sort.Direction.ASC, "time"));
        return ranks.stream()
                .map(rank -> new RankResponse(
                        rank.getNickname(),
                        rank.getTime(),
                        rank.getEndTime()
                ))
                .collect(Collectors.toList());
    } */

    public List<RankResponse> getAllRanks(String nickname, LocalTime time) {
        saveRank(nickname, time);
        List<Rank> ranks = rankRepository.findAll(Sort.by(Sort.Direction.ASC, "time"));
        return ranks.stream()
                .map(rank -> new RankResponse(
                        rank.getNickname(),
                        rank.getTime(),
                        rank.getEndTime()
                ))
                .collect(Collectors.toList());
    }
}
