package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.NoticeResponseBody;
import com.askie01.springsecuritytutorial.model.Notice;

public interface NoticeToNoticeResponseBodyMapper
        extends Mapper<Notice, NoticeResponseBody>,
        ToDTOMapper<Notice, NoticeResponseBody> {
}
