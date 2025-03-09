package com.badar.llp.Controllers;

import com.badar.llp.Services.AiService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/llm/")
@CrossOrigin(origins = "*")
public class DeepSeekController {

    //private final ChatClient chatClient;

    @Autowired
    AiService aiService;


    @GetMapping("/{chat}")
    public String promptWithPathVariable(@PathVariable String chat) {
        try {
            return aiService.getAIHelp(chat);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}

