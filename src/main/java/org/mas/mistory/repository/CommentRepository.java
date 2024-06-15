package org.mas.mistory.repository;

import org.mas.mistory.dto.UserCommentResponse;
import org.mas.mistory.entity.BoardType;
import org.mas.mistory.entity.Comment;
import org.mas.mistory.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
    List<Comment> findByMemberId(Long userId);

    // Comment 엔티티를 기준으로 Post와 Member 엔티티를 조인하여 특정 게시판 타입의 게시글 및 댓글 정보를 가져오는 쿼리
    @Query("SELECT c FROM Comment c JOIN FETCH c.post p JOIN FETCH c.member WHERE p.boardType = :boardType")
    List<Comment> findCommentsWithPostsByBoardType(@Param("boardType") BoardType boardType);
}
