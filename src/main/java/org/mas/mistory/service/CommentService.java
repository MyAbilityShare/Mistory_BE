package org.mas.mistory.service;

import org.mas.mistory.dto.CommentResponse;
import org.mas.mistory.entity.Comment;
import org.mas.mistory.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<CommentResponse> getCommentsByPostId(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream()
                .map(comment -> new CommentResponse(
                        comment.getContent(),
                        comment.getUser().getUserName() // User의 이름 가져오기
                ))
                .collect(Collectors.toList());
    }
}
