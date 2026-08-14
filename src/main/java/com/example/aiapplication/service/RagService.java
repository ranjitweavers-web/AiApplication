package com.example.aiapplication.service;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.store.embedding.EmbeddingSearchRequest;
import dev.langchain4j.store.embedding.EmbeddingSearchResult;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingMatch;
import org.springframework.stereotype.Service;

@Service
public class RagService {

	private final EmbeddingModel embeddingModel;
	private final EmbeddingStore<TextSegment> embeddingStore;
	private final OpenAiChatModel chatModel;

	public RagService(EmbeddingModel embeddingModel, EmbeddingStore<TextSegment> embeddingStore, OpenAiChatModel chatModel) {
		this.embeddingModel = embeddingModel;
		this.embeddingStore = embeddingStore;
		this.chatModel = chatModel;
	}

	public String ask(String question) {

		// 1. Convert question into embedding
		var questionEmbedding = embeddingModel.embed(question).content();

		// 2. Search PostgreSQL for similar chunks
		EmbeddingSearchRequest searchRequest = EmbeddingSearchRequest.builder()
						.queryEmbedding(questionEmbedding)
						.maxResults(3)
						.build();

		EmbeddingSearchResult<TextSegment> searchResult = embeddingStore.search(searchRequest);

		System.out.println("========== SEARCH RESULTS ==========");

		for (EmbeddingMatch<TextSegment> match : searchResult.matches()) {

			System.out.println("Score: " + match.score());
			System.out.println("Text: " + match.embedded().text());
			System.out.println("-----------------------------------");
		}

		// 3. Build context from retrieved chunks
		StringBuilder context = new StringBuilder();

		for (EmbeddingMatch<TextSegment> match : searchResult.matches()) {
			context.append(match.embedded().text())
					.append("\n\n");
		}

		//System.out.println("context: " + context);

		// 4. Send context + question to LLM
		String prompt = """
        You are a helpful question-answering assistant.

        Answer the user's question using the provided context.

        Rules:
        1. The context is the source of truth.
        2. If the context contains information that answers the question,
           use that information to answer.
        3. The user's wording does not need to exactly match the context.
        4. Do not add information that is not supported by the context.
        5. If the context does not contain the answer, respond:
           "The information is not available in the documents."
        6. Keep the answer concise.

        Context:
        %s

        Question:
        %s

        Answer:
        """.formatted(context, question);

		return chatModel.chat(prompt);
	}
}