package com.myorg.linkly.dto.request;

import lombok.Data;

@Data
public class UserRequestDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
