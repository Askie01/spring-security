package com.askie01.springsecuritytutorial.controller;

import com.askie01.springsecuritytutorial.dto.ContactRequestBody;
import com.askie01.springsecuritytutorial.dto.ContactResponseBody;
import com.askie01.springsecuritytutorial.mapper.ContactToContactResponseBodyMapper;
import com.askie01.springsecuritytutorial.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(path = "/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService service;
    private final ContactToContactResponseBodyMapper contactMapper;

    @PostMapping
    public ResponseEntity<Void> createContact(@RequestBody ContactRequestBody requestBody) {
        service.createContact(requestBody);
        final String subject = requestBody.getSubject();
        final URI uri = URI.create("/contacts?subject=" + subject);
        return ResponseEntity
                .created(uri)
                .build();
    }

    @GetMapping
    public ResponseEntity<List<ContactResponseBody>> getContact(@RequestParam String subject) {
        final List<ContactResponseBody> responseBody = service
                .getContacts(subject)
                .stream()
                .map(contactMapper::mapToDTO)
                .toList();
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping
    public ResponseEntity<List<ContactResponseBody>> getContact() {
        final List<ContactResponseBody> responseBody = service
                .getContacts()
                .stream()
                .map(contactMapper::mapToDTO)
                .toList();
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(responseBody);
    }
}
