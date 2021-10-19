package com.angelsofdeath.chattingservice.service;

import com.angelsofdeath.chattingservice.entity.Message;
import com.angelsofdeath.chattingservice.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private MessageRepository messageRepository = new MessageRepository();

    public List<Message> getMessages() {
        return messageRepository.getMessages();
    }
}
