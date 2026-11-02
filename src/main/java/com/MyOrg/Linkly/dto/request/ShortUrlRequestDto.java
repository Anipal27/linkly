package com.MyOrg.Linkly.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class ShortUrlRequestDto {
    private Long userId;
    private String originalUrl;
    private String shortCode;
    private List<Long> tags;
}
