package com.MyOrg.Linkly.dto.reponse;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
}
