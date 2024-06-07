package org.mas.mistory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mas.mistory.entity.Post;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class CreatePostRequest {
    private Long userId;
    private String title;
    private String content;
}
