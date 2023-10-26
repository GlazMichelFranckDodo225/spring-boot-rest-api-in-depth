package com.dgmf.service.impl;

import com.dgmf.entity.User;
import com.dgmf.mapper.UserMapper;
import com.dgmf.repository.UserRepository;
import com.dgmf.service.UserService;
import com.dgmf.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDTO) {
        // Convert UserDto into User JPA Entity
        User user = UserMapper.mapUserDtoToUser(userDTO);

        User savedUser = userRepository.save(user);

        // Convert User JPA Entity into UserDto
        UserDto savedUserDto = UserMapper.mapUserToUserDto(savedUser);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).get();

        UserDto userDtoResponse = UserMapper.mapUserToUserDto(user);

        return userDtoResponse;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserDto> userDtos = new ArrayList<>();

        for (User user: users) {
            UserDto userDtoResponse = UserDto.builder()
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .build();

            userDtos.add(userDtoResponse);
        }

        return userDtos;
    }

    @Override
    public UserDto updateUser(
            UserDto UserDto,
            Long UserDtoId) {
        User existingUser = userRepository
                .findById(UserDtoId).get();

        existingUser.setFirstName(UserDto.getFirstName());
        existingUser.setLastName(UserDto.getLastName());
        existingUser.setEmail(UserDto.getEmail());

        User updatedUser = userRepository.save(existingUser);

        UserDto userDtoResponse = UserMapper.mapUserToUserDto(updatedUser);

        return userDtoResponse;
    }

    @Override
    public void deleteUserById(Long UserDtoId) {
        userRepository.deleteById(UserDtoId);
    }
}
