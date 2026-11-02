package com.myorg.linkly.service;

import com.myorg.linkly.dto.reponse.TagResponseDto;

import java.util.List;

public interface TagService {
    List<TagResponseDto> getAllTags();
}
