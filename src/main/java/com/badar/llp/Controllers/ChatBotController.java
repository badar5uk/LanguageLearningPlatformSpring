package com.badar.llp.Controllers;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatBotController {


    private ChatClient chatClient;

    public ChatBotController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }


    @RequestMapping(value = "/ai", method = RequestMethod.GET)
    public String generation(@RequestParam(value = "message", defaultValue = "Tell me th best language to learn") String message) {
        return chatClient.prompt().user(message)
                .call()
                .content();
    }
}
