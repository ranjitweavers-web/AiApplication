package com.example.aiapplication.config;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiEmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.pgvector.PgVectorEmbeddingStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Value("${spring.ai.openai.api-key}")
    private String apiKey;

    @Value("${spring.ai.openai.chat.model}")
    private String modelName;

    @Value("${spring.datasource.username}")
    private String databaseUser;

    @Value("${spring.datasource.password}")
    private String databasePassword;

    private final String DATABASE_NAME = "aiapplication";


    @Bean
    public OpenAiChatModel openAiChatModel() {

        return OpenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName(modelName)
                .temperature(0.0)
                .build();
    }

    @Bean
    public EmbeddingModel embeddingModel() {

        return OpenAiEmbeddingModel.builder()
                .apiKey(apiKey)
                .modelName("text-embedding-3-small")
                .build();
    }

    @Bean
    public EmbeddingStore<TextSegment> embeddingStore() {

        return PgVectorEmbeddingStore.builder()
                .host("localhost")
                .port(5432)
                .database(DATABASE_NAME)
                .user(databaseUser)
                .password(databasePassword)
                .table("document_embeddings")
                .dimension(1536)
                .build();
    }
}