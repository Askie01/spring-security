package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.NoticeResponseBody;
import com.askie01.springsecuritytutorial.model.Notice;

import java.time.LocalDateTime;

public class DefaultNoticeToNoticeResponseBodyMapper implements NoticeToNoticeResponseBodyMapper {

    @Override
    public NoticeResponseBody mapToDTO(Notice notice) {
        final NoticeResponseBody noticeResponseBody = new NoticeResponseBody();
        map(notice, noticeResponseBody);
        return noticeResponseBody;
    }

    @Override
    public void map(Notice source, NoticeResponseBody target) {
        mapTitle(source, target);
        mapContent(source, target);
        mapDate(source, target);
    }

    private void mapTitle(Notice source, NoticeResponseBody target) {
        final String title = source.getTitle();
        target.setTitle(title);
    }

    private void mapContent(Notice source, NoticeResponseBody target) {
        final String content = source.getContent();
        target.setContent(content);
    }

    private void mapDate(Notice source, NoticeResponseBody target) {
        final LocalDateTime date = source.getCreatedAt();
        target.setDate(date);
    }
}
