package com.dgmf.service.impl;

import com.dgmf.entity.User;
import com.dgmf.exception.ResourceNotFoundException;
import com.dgmf.mapper.AutoUserMapper;
import com.dgmf.mapper.UserMapper;
import com.dgmf.repository.UserRepository;
import com.dgmf.service.UserService;
import com.dgmf.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDTO) {
        // Convert UserDto into User JPA Entity
        // User user = UserMapper.mapUserDtoToUser(userDTO);

        // Using ModelMapper API
        // User user = modelMapper.map(userDTO, User.class);

        // Using MapStruct API
        User user = AutoUserMapper.MAPPER.mapToUser(userDTO);

        User savedUser = userRepository.save(user);

        // Convert User JPA Entity into UserDto
        // UserDto savedUserDto = UserMapper.mapUserToUserDto(savedUser);

        // Using ModelMapper API
        // UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        // Using MapStruct API
        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        // User user = userRepository.findById(userId).get();
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );

        // UserDto userDtoResponse = UserMapper.mapUserToUserDto(user);

        // Using ModelMapper API
        // UserDto userDtoResponse = modelMapper.map(user, UserDto.class);

        // Using MapStruct API
        UserDto userDtoResponse = AutoUserMapper.MAPPER.mapToUserDto(user);

        return userDtoResponse;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        /*return users.stream()
                .map(UserMapper::mapUserToUserDto)
                .collect(Collectors.toList());*/

        // Using ModelMapper API
        /*return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());*/

        // Using MapStruct API
        return users.stream()
                .map(user -> AutoUserMapper.MAPPER.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userDtoId) {
        // User existingUser = userRepository.findById(UserDtoId).get();
        User existingUser = userRepository.findById(userDtoId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userDtoId)
        );

        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());

        User updatedUser = userRepository.save(existingUser);

        // return UserMapper.mapUserToUserDto(updatedUser);

        // Using ModelMapper API
        // return modelMapper.map(updatedUser, UserDto.class);

        // Using MapStruct API
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUserById(Long userDtoId) {
        User existingUser = userRepository.findById(userDtoId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userDtoId)
        );

        userRepository.deleteById(existingUser.getId());
    }
}
