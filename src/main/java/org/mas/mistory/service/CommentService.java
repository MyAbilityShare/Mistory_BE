package org.mas.mistory.service;

import lombok.RequiredArgsConstructor;
import org.mas.mistory.dto.CommentResponse;
import org.mas.mistory.entity.Comment;
import org.mas.mistory.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    // 비밀댓글 여부가 true이면 댓글 내용을 "비밀 댓글입니다.", 사용자 이름을 "***"으로 return
//    public List<CommentResponse> getCommentsByPostId(Long postId) {
//        List<Comment> comments = commentRepository.findByPostId(postId);
//        return comments.stream()
//                .map(comment -> new CommentResponse(
//                        comment.isPrivate() ? "비밀 댓글입니다." : comment.getContent(),
//                        comment.isPrivate() ? "***" : comment.getUser().getUserName(), // User의 이름 가져오기
//                        comment.isPrivate()
//                ))
//                .collect(Collectors.toList());
//    }
}
