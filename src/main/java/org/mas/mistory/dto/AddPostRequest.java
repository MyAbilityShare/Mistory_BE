package org.mas.mistory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mas.mistory.entity.Post;
import org.mas.mistory.entity.User;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddPostRequest {
    private Long userId;
    private String title;
    private String content;
    private String boardType;
    private LocalDate postDate;
}
