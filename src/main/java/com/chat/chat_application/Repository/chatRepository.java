package com.chat.chat_application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chat.chat_application.Model.chatMessage;

public interface chatRepository extends JpaRepository<chatMessage, Long>{
    List<chatMessage> findBySender(String sender);
    List<chatMessage> findByContentContaining(String keyword);
}
