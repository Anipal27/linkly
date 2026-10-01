package com.MyOrg.Linkly.dto.request;

import lombok.Data;

@Data
public class UserRequestDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
