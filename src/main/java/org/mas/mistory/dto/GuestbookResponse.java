package org.mas.mistory.dto;

import lombok.Getter;
import org.mas.mistory.entity.Guestbook;
import org.mas.mistory.entity.Major;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class GuestbookResponse {
    private Major major;
    private String name;
    private String content;
    private String createdAt;

    public GuestbookResponse(Guestbook guestBook) {
        this.major = guestBook.getMajor();
        this.name = guestBook.getName();
        this.content = guestBook.getContent();
        this.createdAt = formatDateTime(guestBook.getCreatedAt());
    }

    private String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd . hh:mm");
        return dateTime.format(formatter);
    }
}