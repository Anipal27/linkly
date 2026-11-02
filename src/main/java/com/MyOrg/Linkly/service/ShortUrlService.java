package com.MyOrg.Linkly.service;

import com.MyOrg.Linkly.dto.reponse.GenericResponseDto;
import com.MyOrg.Linkly.dto.request.ShortUrlRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface ShortUrlService {
    GenericResponseDto generateShortUrl(ShortUrlRequestDto shortUrlRequestDto);
    String getOriginalUrl(String shortCode);
}
