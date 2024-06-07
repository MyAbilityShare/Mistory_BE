package org.mas.mistory.service;

import org.mas.mistory.dto.CreatePostRequest;
import org.mas.mistory.entity.Post;
import org.mas.mistory.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getPostsByBoardType(String boardType) {
        return postRepository.findAllByBoardType(boardType);
    }

//    public CreatePostRequest create(Long userId, CreatePostRequest request) {
//        Post post = Post.builder()
//                .
//                .build();
//    }
}
