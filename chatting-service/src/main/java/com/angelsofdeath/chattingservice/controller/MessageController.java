package com.angelsofdeath.chattingservice.controller;

import com.angelsofdeath.chattingservice.entity.Message;
import com.angelsofdeath.chattingservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getMessages(){
        return messageService.getMessages();
    }
}
