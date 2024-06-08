package org.mas.mistory.controller;

import lombok.RequiredArgsConstructor;
import org.mas.mistory.dto.CreatePostRequest;
import org.mas.mistory.dto.PostDetailResponse;
import org.mas.mistory.dto.PostListResponse;
import org.mas.mistory.entity.BoardType;
import org.mas.mistory.entity.Post;
import org.mas.mistory.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // board_type(카테고리)별로 게시글 조회
    // @GetMapping("/posts/{boardType}")
    @RequestMapping(value = "/posts/{boardType}", method = RequestMethod.GET, params = "type=boardType")
    public ResponseEntity<List<PostListResponse>> getPostsByBoardType(@PathVariable BoardType boardType) {
        List<PostListResponse> posts = postService.getPostsByBoardType(boardType);
        return ResponseEntity.ok().body(posts);
    }

    // 게시글 작성
    @PostMapping("/posts")
    public ResponseEntity<String> createPost(@RequestBody CreatePostRequest request) {
        postService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body("게시글이 작성되었습니다.");

    }

    // 게시글 및 댓글 목록 상세 조회
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDetailResponse> getPostDetail(@PathVariable Long postId) {
        PostDetailResponse postDetail = postService.getPostDetail(postId);

        return ResponseEntity.ok().body(postDetail);
    }
}
