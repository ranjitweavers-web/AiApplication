package com.example.aiapplication.controller;

import com.example.aiapplication.request.RagRequest;
import com.example.aiapplication.response.ApiResponse;
import com.example.aiapplication.service.DocumentService;
import com.example.aiapplication.service.RagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

	private final DocumentService documentService;
	private final RagService ragService;

	public DocumentController(DocumentService documentService, RagService ragService) {
		this.documentService = documentService;
		this.ragService = ragService;
	}

	@PostMapping("/add")
	ResponseEntity<ApiResponse<String>> addDocuments(@RequestParam("file") MultipartFile file){
		documentService.addDocument(file);
		return ResponseEntity.ok(new ApiResponse<>("Document added successfully", null));
	}

	@PostMapping("/ask")
	public ResponseEntity<ApiResponse<String>> ask(@RequestBody RagRequest request) {
		return ResponseEntity.ok(new ApiResponse<>("Answer fetched successfully", ragService.ask(request.getQuestion())));
	}



}
