package com.example.aiapplication.controller;

import com.example.aiapplication.request.QueryRequest;
import com.example.aiapplication.response.ApiResponse;
import com.example.aiapplication.response.QueryResponse;
import com.example.aiapplication.service.AiService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api")
public class AiController {
    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/ask-questions")
    public ResponseEntity<ApiResponse<QueryResponse>> askQuestion(@RequestBody @Valid QueryRequest queryRequest) {
        return ResponseEntity.ok(new ApiResponse<>(aiService.ask(queryRequest)));
    }
}
