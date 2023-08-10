package fr.my.chat;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Message{
    private Long    id;
    private Long    roomId;
    private Long    authorId;
    private String  MsgText;
    private String  sendAt;


    public Long getId() {
        return this.id;
    }

    public Long authorId() {
        return this.authorId;
    }

    public Long getRoomId() {
        return this.roomId;
    }

    public String getContent() {
        return this.MsgText;
    }

    // hashCode
    @Override
    public int hashCode(){
        String code = "" + this.id;
        return (code.hashCode());
    }


    // equals
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj != null){
            Message msg = (Message) obj;
            if (msg.getId() == this.roomId)
                return true;
        }
        return false;
    }

    // toString()
    @Override
    public String toString(){
        return "Message{" + "author Id=" + this.authorId + ", roomId ='" + this.roomId + ", content: " +  this.MsgText +  '\'' + '}';
    }
}   
