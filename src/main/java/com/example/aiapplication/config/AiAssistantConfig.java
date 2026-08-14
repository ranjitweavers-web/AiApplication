package com.example.aiapplication.config;

import com.example.aiapplication.util.AiAssistant;
import com.example.aiapplication.util.ProductTool;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiAssistantConfig {

	@Bean
	public AiAssistant aiAssistant(OpenAiChatModel openAiChatModel, ProductTool productTool) {

		return AiServices.builder(AiAssistant.class)
				.chatModel(openAiChatModel)
				.tools(productTool)
				.build();
	}
}