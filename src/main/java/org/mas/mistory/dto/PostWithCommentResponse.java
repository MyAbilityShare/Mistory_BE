package org.mas.mistory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
public class PostWithCommentResponse {
    private Long postId;
    private String title;
    private String content;
    private List<CommentResponse> comments;
}
