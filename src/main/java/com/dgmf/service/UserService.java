package com.dgmf.service;

import com.dgmf.web.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userDtoId);
    List<UserDto> getAllUsers();
    UserDto updateUser(
            UserDto userDto, Long userDtoId);
    void deleteUserById(Long userDtoId);
}
