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
        String response = aiAssistant.answer(queryRequest.getQuestions());
        return QueryResponse.of(response);
    }
}
