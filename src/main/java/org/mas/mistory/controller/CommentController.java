package org.mas.mistory.controller;

import lombok.extern.slf4j.Slf4j;
import org.mas.mistory.dto.CommentResponse;
import org.mas.mistory.entity.Comment;
import org.mas.mistory.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 특정 게시글에 달린 댓글 조회
//    @GetMapping("/posts/{postId}/comments")
//    public ResponseEntity<List<CommentResponse>> getCommentsByPostId(@PathVariable Long postId) {
//        List<CommentResponse> comments = commentService.getCommentsByPostId(postId);
//        return ResponseEntity.ok().body(comments);
//    }
}
