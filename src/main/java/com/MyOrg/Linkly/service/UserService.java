package com.MyOrg.Linkly.service;

import com.MyOrg.Linkly.dto.reponse.GenericResponseDto;
import com.MyOrg.Linkly.dto.reponse.UserResponseDto;
import com.MyOrg.Linkly.dto.request.UserRequestDto;

import java.util.List;

public interface UserService {
UserResponseDto userRegistration(UserRequestDto userRequestDto);
List<UserResponseDto> getAllUser();
UserResponseDto getUserById(Long id);
UserResponseDto updateUser(UserRequestDto userRequestDto, Long id);
GenericResponseDto removeUser(Long id);
UserResponseDto getUserByEmail(String email);
List<UserResponseDto> getUserByFirstname(String firstname);
List<UserResponseDto> getUserByFirstnameAndLastname(String firstname, String lastname);
}
