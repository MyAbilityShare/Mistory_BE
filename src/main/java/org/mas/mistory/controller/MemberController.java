package org.mas.mistory.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mas.mistory.dto.RegisterMemberRequest;
import org.mas.mistory.entity.Member;
import org.mas.mistory.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<String> registerMember(@RequestBody RegisterMemberRequest request) {
        Member registered = memberService.register(request);

        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입에 성공했습니다");
    }

}
