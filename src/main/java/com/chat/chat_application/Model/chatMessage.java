package com.chat.chat_application.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="chatmessage")
public class chatMessage {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String sender;
    private String content;
    
    @Enumerated(EnumType.STRING)
    private MessageType type;
    
    public enum MessageType {
        CHAT, JOIN, LEAVE
    }
    public Long getId() {
        return id;
    }
    
    public String getSender()
    {
        return sender;
    }
    public void setSender(String sender)
    {
        this.sender=sender;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content)
    {
        this.content=content;
    }
    public MessageType getType()
    {
        return type;
    }
    public void setType(MessageType type)
    {
        this.type=type;
    }
}
