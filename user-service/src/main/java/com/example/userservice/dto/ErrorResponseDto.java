// dto/ErrorDTO.java
package com.example.userservice.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDto {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private Map<String, String> errors;
}

