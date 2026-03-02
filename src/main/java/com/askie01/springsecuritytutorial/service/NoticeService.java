package com.askie01.springsecuritytutorial.service;

import com.askie01.springsecuritytutorial.model.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> getNotices();
}
