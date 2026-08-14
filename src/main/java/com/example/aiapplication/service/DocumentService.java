package com.example.aiapplication.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DocumentService {

	private final DocumentProcessingService documentProcessingService;

	private static final String UPLOAD_DIR = "documents";

	public DocumentService(DocumentProcessingService documentProcessingService) {

		this.documentProcessingService = documentProcessingService;
	}

	public void addDocument(MultipartFile file) {

		try {

			Path directory = Paths.get(UPLOAD_DIR);

			if (!Files.exists(directory)) {
				Files.createDirectories(directory);
			}
			documentProcessingService.processPdfAsync(directory.resolve(file.getOriginalFilename()));

			Path filePath = directory.resolve(file.getOriginalFilename());
			Files.write(filePath, file.getBytes());


		} catch (Exception e) {
			throw new RuntimeException("Failed to add document", e);
		}
	}

}