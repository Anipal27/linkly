package com.myorg.linkly.service;

import com.myorg.linkly.dto.reponse.TagResponseDto;
import com.myorg.linkly.entity.Tag;
import com.myorg.linkly.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<TagResponseDto> getAllTags() {
        List<Tag> tagList = tagRepository.findAll();
        List<TagResponseDto> tagResponseDtoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagResponseDtoList.add(mapTagToTagResponseDto(tag));
        }

        return tagResponseDtoList;
    }

    // helper methods

    // map Tag to TagResponseDto
    private TagResponseDto mapTagToTagResponseDto(Tag tag) {
        TagResponseDto tagResponseDto = new TagResponseDto();
        tagResponseDto.setId(tag.getId());
        tagResponseDto.setTag(tag.getTag());
        return tagResponseDto;
    }
}
