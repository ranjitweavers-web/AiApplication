package com.example.aiapplication.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryResponse {
    private String response;
    public static QueryResponse of(String response) {
        return QueryResponse.builder()
                .response(response)
                .build();
    }
}
