package org.mas.mistory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCommentResponse {
    private Long commentId;
    private String content;
}
