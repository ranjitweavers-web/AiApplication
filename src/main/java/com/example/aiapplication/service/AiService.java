package com.example.aiapplication.service;


import com.example.aiapplication.request.QueryRequest;
import com.example.aiapplication.response.QueryResponse;
import com.example.aiapplication.util.AiAssistant;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final AiAssistant aiAssistant;

	public AiService(AiAssistant aiAssistant) {
		this.aiAssistant = aiAssistant;
	}


	public QueryResponse ask(QueryRequest queryRequest) {

//        String prompt = """
//        Answer the following question in a concise and structured way.
//
//        Rules:
//        1. Give the answer in numbered points.
//        2. Maximum 5 points.
//        3. Each point should contain a maximum of 30 words.
//        4. Do not add unnecessary explanations.
//        5. Use simple language.
//
//        Question:
//        %s
//        """.formatted(queryRequest.getQuestions());
//
//        String response = openAiChatModel.chat(prompt);
//        return QueryResponse.of(response);

        String response = aiAssistant.answer(queryRequest.getQuestions());
        return QueryResponse.of(response);
    }
}
