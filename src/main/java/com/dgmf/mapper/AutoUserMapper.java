package com.dgmf.mapper;

import com.dgmf.entity.User;
import com.dgmf.web.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    // @Mapping(source = "email", target = "emailAddress")
    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);
}
