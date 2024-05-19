package org.mas.mistory.controller;

import org.mas.mistory.dto.AddPostRequest;
import org.mas.mistory.entity.Post;
import org.mas.mistory.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    // board_type(카테고리)별로 게시글 조회
    @GetMapping("/posts/{boardType}")
    public ResponseEntity<List<Post>> getPostsByBoardType(@PathVariable String boardType) {
        List<Post> posts = postService.getPostsByBoardType(boardType);
        return ResponseEntity.ok().body(posts);
    }

    // 방명록 작성
    /* @PostMapping("/posts/{boardType}")
    public ResponseEntity<Post> addPost(@RequestBody AddPostRequest request) {
        Post created = postService.save(request);

        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    } */
}
