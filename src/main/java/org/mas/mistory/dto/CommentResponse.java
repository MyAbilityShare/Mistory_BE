package org.mas.mistory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentResponse {
    private String content;
    private String userName;
    private boolean isPrivate;
}
