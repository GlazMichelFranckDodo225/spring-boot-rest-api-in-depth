package com.dgmf.service.impl;

import com.dgmf.entity.User;
import com.dgmf.mapper.UserMapper;
import com.dgmf.repository.UserRepository;
import com.dgmf.service.UserService;
import com.dgmf.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
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
        User user = modelMapper.map(userDTO, User.class);

        User savedUser = userRepository.save(user);

        // Convert User JPA Entity into UserDto
        // UserDto savedUserDto = UserMapper.mapUserToUserDto(savedUser);
        // Using ModelMapper API
        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).get();

        // UserDto userDtoResponse = UserMapper.mapUserToUserDto(user);
        // Using ModelMapper API
        UserDto userDtoResponse = modelMapper.map(user, UserDto.class);

        return userDtoResponse;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        /*List<UserDto> userDtos = new ArrayList<>();

        for (User user: users) {
            UserDto userDtoResponse = UserDto.builder()
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .build();

            userDtos.add(userDtoResponse);
        }*/

        /*return users.stream()
                .map(UserMapper::mapUserToUserDto)
                .collect(Collectors.toList());*/
        // Using ModelMapper API
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
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

        // return UserMapper.mapUserToUserDto(updatedUser);
        // Using ModelMapper API
        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUserById(Long UserDtoId) {
        userRepository.deleteById(UserDtoId);
    }
}
