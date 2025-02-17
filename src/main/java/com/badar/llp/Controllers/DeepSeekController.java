package com.badar.llp.Controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/llm/")
@CrossOrigin(origins = "*")
public class DeepSeekController {

    private final ChatClient chatClient;

    public DeepSeekController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping("/{chat}")
    public String promptWithPathVariable(@PathVariable String chat) {
        try {
            String response = chatClient
                    .prompt(chat)
                    .call()
                    .content();
            return parseLLMResponse(response);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/stream/{chat}")
    public Flux<String> streamChat(@PathVariable String chat) {
        return chatClient
                .prompt()
                .user(chat)
                .stream()
                .content();
    }

    String parseLLMResponse(String rawInput) {
        Integer index = rawInput.indexOf("</think>");
        return rawInput.substring(index + "</think>".length() + 2).replace("\n", "");
    }
}

