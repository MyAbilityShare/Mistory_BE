package org.mas.mistory.controller;

import org.mas.mistory.entity.Rank;
import org.mas.mistory.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RankController {

    @Autowired
    private RankService rankService;

    @GetMapping("/rank")
    public ResponseEntity<List<Rank>> getAllRanks() {
        List<Rank> ranks = rankService.getAllRanks();
        return ResponseEntity.ok().body(ranks);
    }
}
