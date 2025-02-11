package com.badar.llp.Controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatBotController {

    private final ChatClient chatClient;

    public ChatBotController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ai")
    public String generation(@RequestParam(value ="message", defaultValue = "Tell me th best language to learn") String message) {
        return chatClient.prompt(message).toString();
    }
}
