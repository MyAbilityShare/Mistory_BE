package org.mas.mistory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostListResponse {
    private Long postId;
    private String title;
    private String content;
}
