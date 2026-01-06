package com.askie01.springsecuritytutorial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/notices")
public class NoticeController {

    @GetMapping
    public ResponseEntity<String> getNotice() {
        final String notice = "Notice Details";
        return new ResponseEntity<>(notice, HttpStatus.OK);
    }
}
