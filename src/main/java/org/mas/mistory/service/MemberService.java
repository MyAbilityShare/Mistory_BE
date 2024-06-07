package org.mas.mistory.service;

import lombok.RequiredArgsConstructor;
import org.mas.mistory.dto.RegisterMemberRequest;
import org.mas.mistory.entity.Member;
import org.mas.mistory.entity.Role;
import org.mas.mistory.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Member register(RegisterMemberRequest request) {
        Optional<Member> existingMember = memberRepository.findByUsername(request.getUsername());
        if (existingMember.isPresent()) {
            throw new RuntimeException("동일한 id를 가진 유저가 존재합니다.");
        }

        Member registerMember = Member.builder()
                .username(request.getUsername())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .nickname(request.getNickname())
                .role(Role.valueOf(request.getRole()))
                .build();

        return memberRepository.save(registerMember);
    }
}
