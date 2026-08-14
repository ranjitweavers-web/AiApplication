package com.example.aiapplication.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ApiResponse<T> {
	public ApiResponse(String message, T data) {
		this.message = message;
		this.data = data;
	}

	private String message;
	private T data;

	public ApiResponse(QueryResponse ask) {
	}
}