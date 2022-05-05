package com.example.passwordmgtsystem.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class APIResponse {
    private String message;
    private Boolean isSuccessful;
}
