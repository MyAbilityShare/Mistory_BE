package org.mas.mistory.service;

import lombok.RequiredArgsConstructor;
import org.mas.mistory.dto.CreatePostRequest;
import org.mas.mistory.entity.Member;
import org.mas.mistory.entity.Post;
import org.mas.mistory.repository.MemberRepository;
import org.mas.mistory.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public List<Post> getPostsByBoardType(String boardType) {
        return postRepository.findAllByBoardType(boardType);
    }

    // 게시글(방명록) 작성
    public Post create(CreatePostRequest request) {
        Member member = memberRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("해당하는 사용자를 찾을 수 없습니다."));

        Post post = Post.builder()
                .member(member)
                .title(request.getTitle())
                .content(request.getContent())
                .boardType(request.getBoardType())
                .postDate(LocalDate.now())
                .build();

        return postRepository.save(post);
    }
}
