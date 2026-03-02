package com.askie01.springsecuritytutorial.service;

import com.askie01.springsecuritytutorial.model.Notice;
import com.askie01.springsecuritytutorial.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DefaultNoticeService implements NoticeService {

    private final NoticeRepository repository;

    @Override
    public List<Notice> getNotices() {
        return repository.findAllSortedByNewest();
    }
}
