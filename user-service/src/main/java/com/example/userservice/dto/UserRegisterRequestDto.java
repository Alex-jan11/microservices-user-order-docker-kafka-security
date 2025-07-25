// dto/RegisterRequest.java
package com.example.userservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequestDto {
    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 6)
    private String password;
}

