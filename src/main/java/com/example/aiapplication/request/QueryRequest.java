package com.example.aiapplication.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class QueryRequest {

    @NotBlank(message = "Questions cannot be blank")
    private String questions;
}
