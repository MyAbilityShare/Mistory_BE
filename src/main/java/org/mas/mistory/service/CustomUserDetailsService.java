package org.mas.mistory.service;

import lombok.RequiredArgsConstructor;
import org.mas.mistory.entity.Member;
import org.mas.mistory.entity.CustomUser;
import org.mas.mistory.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> member = memberRepository.findByUsername(username);

        return member.map(CustomUser::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + ": 해당 유저를 찾을 수 없습니다"));
    }
}
