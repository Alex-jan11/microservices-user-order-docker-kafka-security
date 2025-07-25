package com.example.userservice.service;

import com.example.userservice.dto.UserRegisterRequestDto;
import com.example.userservice.dto.UserResponseDto;

public interface IUserService {
    public UserResponseDto registe(UserRegisterRequestDto userRegisterRequestDto);
    public UserResponseDto update(Long userId, UserRegisterRequestDto userRegisterRequestDto);
}
