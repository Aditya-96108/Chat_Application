package com.chat.chat_application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chat.chat_application.Model.chatMessage;
import com.chat.chat_application.Repository.chatRepository;

@Service
public class chatService {
    @Autowired
    private chatRepository chatrepository;

    public chatMessage saveMessage(chatMessage message) {
        return chatrepository.save(message);
    }

    public List<chatMessage> getAllMessages() {
        return chatrepository.findAll();
    }

    public List<chatMessage> getMessagesBySender(String sender) {
        return chatrepository.findBySender(sender);
    }

    public List<chatMessage> getMessagesByContent(String keyword) {
        return chatrepository.findByContentContaining(keyword);
    }
}
