package org.mas.mistory.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mas.mistory.dto.CommentResponse;
import org.mas.mistory.dto.UserCommentResponse;
import org.mas.mistory.entity.Comment;
import org.mas.mistory.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comments")
    public ResponseEntity<List<UserCommentResponse>> getComments(HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // String username = (String) session.getAttribute("username");
        System.out.println(username);

        List<UserCommentResponse> comments = commentService.getComments(username);

        return ResponseEntity.ok().body(comments);
    }

}
