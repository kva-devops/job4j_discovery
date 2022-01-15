package ru.job4j.discoveryclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.discoveryclient.model.Message;
import ru.job4j.discoveryclient.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Value("${spring.application.name}")
    private String appName;

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getMessages() {
        return messageService.getReceivedMessages();
    }

    @PostMapping("/send/{serviceId}")
    public void send(
            @PathVariable String serviceId,
            @RequestBody Message message
    ) {
        message.setSender(appName);
        boolean sent = messageService.send(serviceId, message);
        if (!sent) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Invalid service ID"
            );
        }
    }

    @PostMapping("/receive")
    public void receive(@RequestBody Message message) {
        messageService.saveReceivedMessage(message);
    }
}
