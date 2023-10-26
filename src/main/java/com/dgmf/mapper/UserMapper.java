package com.dgmf.mapper;

import com.dgmf.entity.User;
import com.dgmf.web.dto.UserDto;
import lombok.Builder;
import lombok.Data;

@Data @Builder
public class UserMapper {
    // Convert User JPA Entity into UserDto
    public static UserDto mapUserToUserDto(User user) {
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();

        return userDto;
    }

    // Convert UserDto into User JPA Entity
    public static User mapUserDtoToUser(UserDto userDto) {
        User user = User.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build();

        return user;
    }
}
