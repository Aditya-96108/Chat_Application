package com.chat.chat_application.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import com.chat.chat_application.Model.chatMessage;
import com.chat.chat_application.Service.chatService;
@RestController
@RequestMapping("/chat")
public class chatController {

    @Autowired
    private chatService chatService;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/public")
    public chatMessage sendMessage(chatMessage chatMessage) {
        chatService.saveMessage(chatMessage);
        return chatMessage;
    }

    @GetMapping("/all")
    public ResponseEntity<List<chatMessage>> getAllMessages() {
        List<chatMessage> messages = chatService.getAllMessages();
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/sender/{sender}")
    public ResponseEntity<List<chatMessage>> getMessagesBySender(@PathVariable String sender) {
        List<chatMessage> messages = chatService.getMessagesBySender(sender);
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/search")
    public ResponseEntity<List<chatMessage>> getMessagesByContent(@RequestParam String keyword) {
        List<chatMessage> messages = chatService.getMessagesByContent(keyword);
        return ResponseEntity.ok(messages);
    }
}
