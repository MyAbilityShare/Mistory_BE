package org.mas.mistory.service;

import org.mas.mistory.entity.Rank;
import org.mas.mistory.repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService {

    @Autowired
    private RankRepository rankRepository;

    // 점수가 높은 순서대로 return
    public List<Rank> getAllRanks() {
        return rankRepository.findAll(Sort.by(Sort.Direction.DESC, "score"));
    }
}
