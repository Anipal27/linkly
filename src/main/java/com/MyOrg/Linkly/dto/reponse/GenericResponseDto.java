package com.MyOrg.Linkly.dto.reponse;

import lombok.Data;

@Data
public class GenericResponseDto {

    private String message;
    private Boolean success;
    private Object details;
}