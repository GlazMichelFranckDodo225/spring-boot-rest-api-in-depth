package com.dgmf.service;

import com.dgmf.web.dto.UserDtoRequest;
import com.dgmf.web.dto.UserDtoResponse;

import java.util.List;

public interface UserService {
    UserDtoResponse createUser(UserDtoRequest userDtoRequest);
    UserDtoResponse getUserById(Long userId);
    List<UserDtoResponse> getAllUsers();
    UserDtoResponse updateUser(
            UserDtoRequest userDtoRequest, Long userDtoRequestId);
    void deleteUserById(Long userDtoRequestId);
}
