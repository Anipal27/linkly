package com.myorg.linkly.service;

import com.myorg.linkly.dto.reponse.GenericResponseDto;
import com.myorg.linkly.dto.reponse.UserResponseDto;
import com.myorg.linkly.dto.request.UserRequestDto;

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
