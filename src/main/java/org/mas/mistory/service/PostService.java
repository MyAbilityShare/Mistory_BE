package org.mas.mistory.service;

import lombok.RequiredArgsConstructor;
import org.mas.mistory.dto.CreatePostRequest;
import org.mas.mistory.dto.PostListResponse;
import org.mas.mistory.entity.BoardType;
import org.mas.mistory.entity.Member;
import org.mas.mistory.entity.Post;
import org.mas.mistory.repository.MemberRepository;
import org.mas.mistory.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public List<PostListResponse> getPostsByBoardType(BoardType boardType) {
        List<Post> posts = postRepository.findAllByBoardType(boardType);

        return posts.stream()
                .map(post -> new PostListResponse(
                        post.getId(),
                        post.getTitle(),
                        post.getContent()
                ))
                .collect(Collectors.toList());
    }

    // 게시글(방명록) 작성
    public Post create(CreatePostRequest request) {
        Member member = memberRepository.findById(request.getUserId())
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
