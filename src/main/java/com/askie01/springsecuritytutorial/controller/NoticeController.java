package com.askie01.springsecuritytutorial.controller;

import com.askie01.springsecuritytutorial.dto.NoticeResponseBody;
import com.askie01.springsecuritytutorial.mapper.NoticeToNoticeResponseBodyMapper;
import com.askie01.springsecuritytutorial.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/notices")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService service;
    private final NoticeToNoticeResponseBodyMapper noticeMapper;

    @GetMapping
    public ResponseEntity<List<NoticeResponseBody>> getNotices() {
        final List<NoticeResponseBody> notices = service
                .getNotices()
                .stream()
                .map(noticeMapper::mapToDTO)
                .toList();
        return ResponseEntity.ok(notices);
    }
}
