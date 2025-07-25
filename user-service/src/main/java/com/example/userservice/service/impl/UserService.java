// service/UserService.java
package com.example.userservice.service;

import com.example.userservice.dto.*;
import com.example.userservice.exception.ResourceAlreadyExistsException;
import com.example.userservice.exception.ResourceNotFoundException;
import com.example.userservice.mapper.UserMapper;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto register(UserRegisterRequestDto request) {
        // verificăm dacă username-ul există deja
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new ResourceAlreadyExistsException("Username already exists");
        }

        // mapăm DTO → entitate
        User user = userMapper.toEntity(request);
        user.setRole(Constants.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userMapper.toDto(userRepository.save(user));
    }

    // exemplu: update entitate existentă
    public UserResponseDto update(Long userId, UserRegisterRequestDto updateRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        userMapper.updateEntity(user, updateRequest);

        if (updateRequest.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(updateRequest.getPassword()));
        }

        return userMapper.toDto(userRepository.save(user));
    }

    public UserResponseDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return userMapper.toDto(user);
    }
}

