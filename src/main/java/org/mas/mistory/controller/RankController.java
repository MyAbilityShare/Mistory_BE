package org.mas.mistory.controller;

import lombok.RequiredArgsConstructor;
import org.mas.mistory.dto.RankRequest;
import org.mas.mistory.dto.RankResponse;
import org.mas.mistory.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rank")
@RequiredArgsConstructor
public class RankController {

    private final RankService rankService;

    @PostMapping
    public ResponseEntity<String> saveRank(@RequestBody RankRequest rankRequest) {
        rankService.saveRank(rankRequest);
        return ResponseEntity.ok().body("랭킹이 저장되었습니다");
    }


    @GetMapping
    public ResponseEntity<List<RankResponse>> getAllRanks() {
        List<RankResponse> ranks = rankService.getAllRanks();
        return ResponseEntity.ok(ranks);
    }
}
