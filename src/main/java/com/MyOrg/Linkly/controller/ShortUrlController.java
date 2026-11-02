package com.MyOrg.Linkly.controller;

import com.MyOrg.Linkly.dto.reponse.GenericResponseDto;
import com.MyOrg.Linkly.dto.request.ShortUrlRequestDto;
import com.MyOrg.Linkly.service.ShortUrlService;
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
