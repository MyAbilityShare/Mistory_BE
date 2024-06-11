package org.mas.mistory.service;

import lombok.RequiredArgsConstructor;
import org.mas.mistory.dto.CommentResponse;
import org.mas.mistory.dto.UserCommentResponse;
import org.mas.mistory.entity.Comment;
import org.mas.mistory.entity.Member;
import org.mas.mistory.repository.CommentRepository;
import org.mas.mistory.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;

    public List<UserCommentResponse> getComments(String username) {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당 유저를 찾을 수 없습니다."));

        List<Comment> comments = commentRepository.findByMemberId(member.getId());

        return comments.stream()
                .map(comment -> new UserCommentResponse(
                        comment.getId(),
                        comment.getContent()
                ))
                .collect(Collectors.toList());
    }
}
