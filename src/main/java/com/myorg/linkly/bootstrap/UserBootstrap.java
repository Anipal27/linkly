package com.myorg.linkly.bootstrap;

import com.github.javafaker.Faker;
import com.myorg.linkly.dto.request.UserRequestDto;
import com.myorg.linkly.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class UserBootstrap implements CommandLineRunner {

    private final UserService userService;

    private final Faker faker = new Faker(new Locale("en"));

    private final Random random = new Random();

    @Override
    public void run(String... args) {

        for (int i = 0; i < 1000; i++) {

            UserRequestDto userRequestDto = new UserRequestDto();

            userRequestDto.setFirstname(faker.name().firstName());
            userRequestDto.setLastname(faker.name().lastName());
            userRequestDto.setEmail("user" + i + "@example.com");
            userRequestDto.setPassword("Password@123");
//
//            userRequestDto.setGender(
//                    random.nextBoolean() ? Gender.MALE : Gender.FEMALE
//            );

            userService.registerUser(userRequestDto);
        }

        System.out.println("Successfully registered 1000 random users!");
    }
}