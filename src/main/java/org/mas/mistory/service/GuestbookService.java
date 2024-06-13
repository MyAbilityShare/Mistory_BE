package org.mas.mistory.service;

import lombok.RequiredArgsConstructor;
import org.mas.mistory.dto.CreateGuestbookRequest;
import org.mas.mistory.entity.Guestbook;
import org.mas.mistory.repository.GuestbookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GuestbookService {

    private final GuestbookRepository guestbookRepository;

    public Guestbook create(CreateGuestbookRequest request) {
        Guestbook guestBook = Guestbook.builder()
                .major(request.getMajor())
                .name(request.getName())
                .content(request.getContent())
                .createdAt(LocalDateTime.now())
                .build();

        return guestbookRepository.save(guestBook);
    }
}
