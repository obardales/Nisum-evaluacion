package com.nisum.obardales.service;

import com.nisum.obardales.service.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public UserDto userRegister(UserDto user);

    public List<UserDto> getAll();

}
