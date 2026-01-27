package com.bank.customerprofile.models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class errorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String path;
}
