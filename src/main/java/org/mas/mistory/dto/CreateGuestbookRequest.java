package org.mas.mistory.dto;

import lombok.Getter;
import org.mas.mistory.entity.Major;

@Getter
public class CreateGuestbookRequest {
    private Major major;
    private String name;
    private String content;
}
