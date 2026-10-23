package com.example.aiapplication.service;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
public class DocumentProcessingService {

	private final EmbeddingModel embeddingModel;
	private final EmbeddingStore<TextSegment> embeddingStore;

	public DocumentProcessingService(EmbeddingModel embeddingModel, EmbeddingStore<TextSegment> embeddingStore) {
		this.embeddingModel = embeddingModel;
		this.embeddingStore = embeddingStore;
	}

	@Async
	public void processPdfAsync(Path filePath) {

		try {

			Document document = FileSystemDocumentLoader.loadDocument(filePath, new ApachePdfBoxDocumentParser());
			List<TextSegment> segments = DocumentSplitters.recursive(500, 50).split(document);

			for (TextSegment segment : segments) {

				var embedding = embeddingModel.embed(segment.text()).content();
				embeddingStore.add(embedding, segment);
			}

		} catch (Exception e) {
			System.err.println("PDF processing failed: " + filePath);
			e.printStackTrace();
		}
	}
}
