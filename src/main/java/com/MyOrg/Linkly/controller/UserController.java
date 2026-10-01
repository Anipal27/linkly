package com.MyOrg.Linkly.controller;

import com.MyOrg.Linkly.dto.reponse.GenericResponseDto;
import com.MyOrg.Linkly.dto.reponse.UserResponseDto;
import com.MyOrg.Linkly.dto.request.UserRequestDto;
import com.MyOrg.Linkly.service.UserService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/createuser")
    public ResponseEntity<UserResponseDto> userRegistration(@RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>(userService.userRegistration(userRequestDto), HttpStatusCode.valueOf(201));
    }
    @GetMapping("/getusers")
    public ResponseEntity<List<UserResponseDto>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatusCode.valueOf(200));
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id){
    return new ResponseEntity<>(userService.getUserById(id),HttpStatusCode.valueOf(200));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDto> updateUserByID(@RequestBody UserRequestDto userRequestDto, @PathVariable Long id){
        return new ResponseEntity<>(userService.updateUser(userRequestDto, id),HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponseDto> DeleteUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.removeUser(id), HttpStatusCode.valueOf(200));
    }
    @GetMapping("/user/email")
    public  ResponseEntity<UserResponseDto> getUserByEmail(@RequestParam String email){
        return  new ResponseEntity<>(userService.getUserByEmail(email), HttpStatusCode.valueOf(200));
    }
    @GetMapping("/users/Firstname")
    public ResponseEntity<List<UserResponseDto>> getUserByFirstname(@RequestParam String firstname){
        return new ResponseEntity<>(userService.getUserByFirstname(firstname), HttpStatusCode.valueOf(200));
    }
    @GetMapping("/users/FirstnameAndLastname")
    public ResponseEntity<List<UserResponseDto>> getUserByFirstnameAndLastname(@RequestParam String firstname,String lastname){
        return new ResponseEntity<>(userService.getUserByFirstnameAndLastname(firstname, lastname), HttpStatusCode.valueOf(200));
    }
}
