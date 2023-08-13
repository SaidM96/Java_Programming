package fr.my.chat.models;

import java.util.List;

public class ChatRoom{
    private Long          roomId;
    private Long          ownerId;
    private String        roomName;
    private List<Message> messages;


    public ChatRoom(Long roomId,Long ownerId, String roomName, List<Message> messages){
        this.roomId = roomId;
        this.ownerId = ownerId;
        this.roomName = roomName;
        this.messages = messages;
    }
    public Long getId() {
        return this.roomId;
    }

    public Long getOwner() {
        return this.ownerId;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    // hashCode
    public int hashCode(){
        String code = "" + this.roomId;
        return (code.hashCode());
    }

    // equals
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj != null){
            ChatRoom msg = (ChatRoom) obj;
            if (msg.getId() == this.roomId)
                return true;
        }
        return false;
    }

    // toString()
    public String toString(){
        return "ChatRoom{" + "owner Id=" + this.ownerId + ", room Name='" + this.roomName + ", messages: " +  this.messages +  '\'' + '}';
    }

}