package org.mas.mistory.repository;

import org.mas.mistory.dto.UserCommentResponse;
import org.mas.mistory.entity.BoardType;
import org.mas.mistory.entity.Comment;
import org.mas.mistory.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);

    List<Comment> findByMemberId(Long userId);
}
