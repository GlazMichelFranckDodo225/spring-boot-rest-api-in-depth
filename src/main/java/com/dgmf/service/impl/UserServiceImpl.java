package com.dgmf.service.impl;

import com.dgmf.entity.User;
import com.dgmf.repository.UserRepository;
import com.dgmf.service.UserService;
import com.dgmf.web.dto.UserDtoRequest;
import com.dgmf.web.dto.UserDtoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDtoResponse createUser(UserDtoRequest userDTO) {
        User user = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();

        userRepository.save(user);

        UserDtoResponse userDtoResponse = UserDtoResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();

        return userDtoResponse;
    }

    @Override
    public UserDtoResponse getUserById(Long userId) {
        User user = userRepository.findById(userId).get();

        UserDtoResponse userDtoResponse = UserDtoResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();

        return userDtoResponse;
    }

    @Override
    public List<UserDtoResponse> getAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserDtoResponse> userDtos = new ArrayList<>();

        for (User user: users) {
            UserDtoResponse userDtoResponse = UserDtoResponse.builder()
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .build();

            userDtos.add(userDtoResponse);
        }

        return userDtos;
    }
}
