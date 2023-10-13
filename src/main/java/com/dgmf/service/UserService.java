package com.dgmf.service;

import com.dgmf.web.dto.UserDtoRequest;
import com.dgmf.web.dto.UserDtoResponse;

import java.util.List;

public interface UserService {
    UserDtoResponse createUser(UserDtoRequest userDTO);
    UserDtoResponse getUserById(Long userId);
    List<UserDtoResponse> getAllUsers();
}
