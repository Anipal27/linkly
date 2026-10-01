package com.MyOrg.Linkly.service;

import com.MyOrg.Linkly.dto.reponse.GenericResponseDto;
import com.MyOrg.Linkly.dto.reponse.UserResponseDto;
import com.MyOrg.Linkly.dto.request.UserRequestDto;
import com.MyOrg.Linkly.entity.User;
import com.MyOrg.Linkly.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository ;

    UserServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto userRegistration(UserRequestDto userRequestDto) {
        User user = mapUserRequestDtoToUser(userRequestDto,new User());
        userRepository.save(user);
        return  mapUserToUserResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUser() {
        List<User> userList = userRepository.findAll();
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        for (User user : userList) {
            userResponseDtoList.add(mapUserToUserResponseDto(user));
        }
        return userResponseDtoList;
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return (user!=null)?mapUserToUserResponseDto(user):null;
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto, Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            return null;
        }
        user = userRepository.save(mapUserRequestDtoToUser(userRequestDto,user));
        return mapUserToUserResponseDto(user);
    }

    @Override
    public GenericResponseDto removeUser(Long id) {
        GenericResponseDto genericResponseDto = new GenericResponseDto();
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            genericResponseDto.setMessage("User not found");
            genericResponseDto.setSuccess(false);
            return genericResponseDto;
        }
        genericResponseDto.setMessage("user removed succesfully");
        genericResponseDto.setSuccess(true);
        userRepository.deleteById(id);

        return genericResponseDto;
    }

    @Override
    public UserResponseDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        return (user != null)?mapUserToUserResponseDto(user):null;
    }

    @Override
    public List<UserResponseDto> getUserByFirstname(String firstname) {
        List<User> userList = userRepository.findByFirstname(firstname);
        List<UserResponseDto> userResponseDtoList= new ArrayList<>();
        for(User user: userList){
            userResponseDtoList.add(mapUserToUserResponseDto(user));
        }

        return userResponseDtoList;
    }

    @Override
    public List<UserResponseDto> getUserByFirstnameAndLastname(String firstname, String lastname){
        List<User> userList = userRepository.findByFirstnameContainingAndLastnameContaining(firstname, lastname);
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        for(User user : userList){
            userResponseDtoList.add(mapUserToUserResponseDto(user));
        }

        return userResponseDtoList;
    }


    // Helper Methods

    public User mapUserRequestDtoToUser(UserRequestDto userRequestDto, User user){

        user.setFirstname(userRequestDto.getFirstname());
        user.setLastname(userRequestDto.getLastname());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        return user;
    }

    public UserResponseDto mapUserToUserResponseDto(User user){

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(user.getId());
        userResponseDto.setFirstname(user.getFirstname());
        userResponseDto.setLastname(user.getLastname());
        userResponseDto.setEmail(user.getEmail());

        return userResponseDto;
    }
}
