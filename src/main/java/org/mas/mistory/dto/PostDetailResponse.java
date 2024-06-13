package org.mas.mistory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.mas.mistory.entity.Post;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
public class PostDetailResponse {
    private Long postId;
    private String title;
    private String content;
    private LocalDate postDate;
    private List<CommentResponse> comments;
}
