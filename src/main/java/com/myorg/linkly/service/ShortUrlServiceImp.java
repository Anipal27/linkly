package com.myorg.linkly.service;

import com.myorg.linkly.dto.reponse.GenericResponseDto;
import com.myorg.linkly.dto.request.ShortUrlRequestDto;
import com.myorg.linkly.entity.ShortUrl;
import com.myorg.linkly.entity.Tag;
import com.myorg.linkly.entity.User;
import com.myorg.linkly.repository.ShortUrlRepository;
import com.myorg.linkly.repository.TagRepository;
import com.myorg.linkly.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShortUrlServiceImp implements ShortUrlService {

    @Autowired
    private ShortUrlRepository shortUrlRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public GenericResponseDto generateShortUrl(ShortUrlRequestDto shortUrlRequestDto) {
        User user = userRepository.findById(shortUrlRequestDto.getUserId()).orElse(null);
        if(user == null) {
            throw new RuntimeException("User doesn't exist");
        }

        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setOriginalUrl(shortUrlRequestDto.getOriginalUrl());
        shortUrl.setShortCode(shortUrlRequestDto.getShortCode());
        shortUrl.setUser(user);

        List<Long> tags = shortUrlRequestDto.getTags();

        for(Long tagId : tags) {
            Tag tag = tagRepository.findById(tagId).orElse(null);
            if(tag != null) {
                shortUrl.getTags().add(tag);
            }
        }

        shortUrlRepository.save(shortUrl);

        return new GenericResponseDto("Short url created!", true, Map.of("shortUrl", "http://localhost/" + shortUrlRequestDto.getShortCode()));
    }

    @Override
    public String getOriginalUrl(String shortCode) {
        ShortUrl shortUrl = shortUrlRepository.findByShortCode(shortCode).orElse(null);
        if(shortUrl == null) {
            throw new RuntimeException("Short url doesn't exist");
        }

        return shortUrl.getOriginalUrl();
    }
}
