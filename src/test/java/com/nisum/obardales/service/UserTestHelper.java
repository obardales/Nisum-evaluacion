package com.nisum.obardales.service;

import com.nisum.obardales.service.dto.PhoneDto;
import com.nisum.obardales.service.dto.UserDto;

import java.util.ArrayList;

public class UserTestHelper {

    public static UserDto forRegister() {
        UserDto userDto = new UserDto();
        userDto.setName("Juan Rodriguez");
        userDto.setEmail("juan@rodriguez.org");
        userDto.setPassword("ThisIsMyH4rdP455w0rd!");
        userDto.setPhones(new ArrayList<>());

        userDto.getPhones().add(new PhoneDto("1234567", "1", "57", null));
        userDto.getPhones().add(new PhoneDto("1234568", "2", "67", null));

        return userDto;
    }

}
