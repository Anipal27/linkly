package com.myorg.linkly.service;

import com.myorg.linkly.dto.reponse.GenericResponseDto;
import com.myorg.linkly.dto.request.ShortUrlRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface ShortUrlService {
    GenericResponseDto generateShortUrl(ShortUrlRequestDto shortUrlRequestDto);
    String getOriginalUrl(String shortCode);
}
