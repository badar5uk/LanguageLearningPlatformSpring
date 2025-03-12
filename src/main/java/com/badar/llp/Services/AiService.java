package com.badar.llp.Services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.Map;

@Service
public class AiService {

    @Value("${gemini.api.key}")
    public String GEMINI_API_KEY;


    private final Logger logger = LoggerFactory.getLogger(AiService.class);
/*
    private final ChatClient chatClient;

    public AiService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }*/

  /*  public String promptWithPathVariable(String chat) {
        try {

            logger.info("Chat data: " + chat);
            String response = chatClient
                    .prompt("Answer the following in 4 lines:  " + chat) //input here your desired text
                    .call()
                    .content();
            logger.info("response: " + response);
            return response;
        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
            return "Error: " + e.getMessage();
        }
    }*/

    public String getAPIUrl() {
        return "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + GEMINI_API_KEY;
    }


    public String callGeminiAPI(String json) {
        RestTemplate restTemplate = new RestTemplate();

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        logger.info(json);
        // Wrap request body
        HttpEntity<String> entity = new HttpEntity<>(json, headers);

        // Make POST request
        ResponseEntity<String> response = restTemplate.exchange(getAPIUrl(), HttpMethod.POST, entity, String.class);

        return extractTextFromResponse(response.getBody()); // Return the API response
    }

    public String getAIHelp(String data) {

        Map<String, Object> requestMap = new HashMap<>();
        List<Map<String, Object>> contentsList = new ArrayList<>();
        Map<String, Object> contentsMap = new HashMap<>();

        List<Map<String, String>> partsList = new ArrayList<>();
        Map<String, String> partsMap = new HashMap<>();

        // Set text content with appended asteroid data
        String text = "Answer the following in 4 lines:  " + data;

        partsMap.put("text", text);
        partsList.add(partsMap);

        contentsMap.put("parts", partsList);
        contentsList.add(contentsMap);

        requestMap.put("contents", contentsList);

        try {
            // Use Jackson's ObjectMapper to convert the requestMap to a JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonRequest = objectMapper.writeValueAsString(requestMap);

            // Call the Gemini API with the generated JSON string
            return callGeminiAPI(jsonRequest);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error generating the request.";
        }
    }

    public String extractTextFromResponse(String response) {
        try {
            // Initialize Jackson ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Parse the response string into a JsonNode
            JsonNode rootNode = objectMapper.readTree(response);

            // Navigate to the "candidates" -> "content" -> "parts" -> "text"
            JsonNode candidatesNode = rootNode.path("candidates");
            if (candidatesNode.isArray() && candidatesNode.size() > 0) {
                JsonNode contentNode = candidatesNode.get(0).path("content");
                JsonNode partsNode = contentNode.path("parts");
                if (partsNode.isArray() && partsNode.size() > 0) {
                    JsonNode textNode = partsNode.get(0).path("text");
                    return textNode.asText(); // Return the text content
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null if any issue occurs
    }
}
