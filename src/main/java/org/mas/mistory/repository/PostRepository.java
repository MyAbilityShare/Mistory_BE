package org.mas.mistory.repository;

import org.mas.mistory.entity.BoardType;
import org.mas.mistory.entity.Comment;
import org.mas.mistory.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
