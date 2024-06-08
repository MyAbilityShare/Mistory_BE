package org.mas.mistory.controller;

import lombok.RequiredArgsConstructor;
import org.mas.mistory.dto.CreatePostRequest;
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
    @GetMapping("/posts/{boardType}")
    public ResponseEntity<List<Post>> getPostsByBoardType(@PathVariable String boardType) {
        List<Post> posts = postService.getPostsByBoardType(boardType);
        return ResponseEntity.ok().body(posts);
    }

    // 게시글 작성
    @PostMapping("/posts")
    public ResponseEntity<String> createPost(@RequestBody CreatePostRequest request) {
        postService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body("게시글이 작성되었습니다.");

    }
}
