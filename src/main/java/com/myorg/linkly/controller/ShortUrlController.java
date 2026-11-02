package com.myorg.linkly.controller;

import com.myorg.linkly.dto.reponse.GenericResponseDto;
import com.myorg.linkly.dto.request.ShortUrlRequestDto;
import com.myorg.linkly.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class ShortUrlController {
    @Autowired
    private ShortUrlService shortUrlService;

    @PostMapping("/api/short-urls")
    public ResponseEntity<GenericResponseDto> generateShortUrl(@RequestBody ShortUrlRequestDto shortUrlRequestDto) {
        return new ResponseEntity<>(shortUrlService.generateShortUrl(shortUrlRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> getShortUrl(@PathVariable String shortCode) {
        String originalUrl = shortUrlService.getOriginalUrl(shortCode);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl)).build();
    }
}
