package com.badar.llp.Controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ResponseEntity;
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
    public ResponseEntity<String> promptWithPathVariable(@PathVariable String chat) {
        try {
            String response = chatClient
                    .prompt(chat)
                    .call()
                    .content();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
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
}

