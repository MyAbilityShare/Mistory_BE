package org.mas.mistory.controller;

import lombok.RequiredArgsConstructor;
import org.mas.mistory.dto.CreateGuestbookRequest;
import org.mas.mistory.service.GuestbookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GuestbookController {

    private final GuestbookService guestbookService;

    @PostMapping("/guestbooks")
    public ResponseEntity<String> createGuestbook(@RequestBody CreateGuestbookRequest request) {
        guestbookService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body("방명록이 작성되었습니다.");
    }
}
