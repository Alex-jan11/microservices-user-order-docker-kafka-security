// mapper/UserMapper.java
package com.example.userservice.mapper;

import com.example.userservice.dto.*;
import com.example.userservice.model.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRegisterRequestDto userRegisterRequestDto);

    UserResponseDto toDto(User user);

    // actualizează un user existent cu datele din request
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget User user,  UserRegisterRequestDto userRegisterRequestDto);
}

