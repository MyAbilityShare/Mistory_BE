package org.mas.mistory.service;

import lombok.RequiredArgsConstructor;
import org.mas.mistory.dto.CommentResponse;
import org.mas.mistory.dto.CreatePostRequest;
import org.mas.mistory.dto.PostWithCommentResponse;
import org.mas.mistory.dto.PostListResponse;
import org.mas.mistory.entity.BoardType;
import org.mas.mistory.entity.Comment;
import org.mas.mistory.entity.Member;
import org.mas.mistory.entity.Post;
import org.mas.mistory.repository.CommentRepository;
import org.mas.mistory.repository.MemberRepository;
import org.mas.mistory.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

@Service
@RequiredArgsConstructor
public class PostService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

//    public List<PostListResponse> getPostsByBoardType(BoardType boardType) {
//        List<Post> posts = postRepository.findAllByBoardType(boardType);
//
//        return posts.stream()
//                .map(post -> new PostListResponse(
//                        post.getId(),
//                        post.getTitle(),
//                        post.getContent()
//                ))
//                .collect(Collectors.toList());
//    }

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

//    public PostWithCommentResponse getPostDetail(Long postId) {
//        Post post = postRepository.findById(postId)
//                .orElseThrow(() -> new RuntimeException("해당 게시글을 찾을 수 없습니다."));
//
//        List<Comment> comments = commentRepository.findByPostId(postId);
//        List<CommentResponse> commentResponses = comments.stream()
//                .map(comment -> new CommentResponse(
//                        comment.getId(),
//                        comment.isPrivate() ? "비밀 댓글입니다." : comment.getContent(),
//                        comment.isPrivate() ? "***" : comment.getMember().getNickname(),
//                        comment.isPrivate()))
//                .collect(Collectors.toList());
//
//        return new PostWithCommentResponse(
//                post.getId(),
//                post.getTitle(),
//                post.getContent(),
//                post.getPostDate(),
//                commentResponses
//        );
//    }

    public List<PostWithCommentResponse> getPostsWithCommentByBoardType(BoardType boardType) {
        // Comment 엔티티를 기준으로 조회
        List<Comment> comments = commentRepository.findCommentsWithPostsByBoardType(boardType);

        // Post 엔티티를 기준으로 그룹화
        /* Map<Post, List<Comment>> postCommentsMap = comments.stream()
                .collect(Collectors.groupingBy(Comment::getPost)); */

        Map<Post, List<Comment>> postCommentsMap = comments.stream()
                .collect(Collectors.groupingBy(
                        Comment::getPost,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));

        // 각 Post 엔티티에 대해 PostWithCommentResponse 생성
        return postCommentsMap.entrySet().stream()
                .map(entry -> {
                    Post post = entry.getKey();
                    List<CommentResponse> commentResponses = entry.getValue().stream()
                            .map(comment -> {
                                String content = comment.isPrivate() ? "비밀 댓글입니다." : comment.getContent();
                                String nickname = comment.isPrivate() ? "***" : comment.getMember().getNickname();
                                return new CommentResponse(comment.getId(), content, nickname, comment.isPrivate());
                            })
                            .collect(Collectors.toList());
                    return new PostWithCommentResponse(post.getId(), post.getTitle(), post.getContent(), commentResponses);
                })
                .collect(Collectors.toList());
    }

}
