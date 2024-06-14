package org.mas.mistory.service;

import lombok.RequiredArgsConstructor;
import org.mas.mistory.dto.CreateGuestbookRequest;
import org.mas.mistory.dto.GuestbookResponse;
import org.mas.mistory.entity.Guestbook;
import org.mas.mistory.repository.GuestbookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<GuestbookResponse> getAllGuestbooks() {
        List<Guestbook> guestBookList = guestbookRepository.findAll();

        return guestBookList.stream()
                .map(GuestbookResponse::new)
                .collect(Collectors.toList());
    }

}
