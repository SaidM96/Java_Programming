package fr.my.chat.models;
import java.sql.Timestamp;

public class Message{
    private Long        id;
    private Long        roomId;
    private ChatRoom    room;
    private Long        authorId;
    private User        author;
    private String      MsgText;
    private Timestamp   dateTime;


    public Message(){
        this.dateTime = new Timestamp(System.currentTimeMillis());
    }

    public Message(Long id, Long roomId, ChatRoom room, User user, Long authorId, String Msg){
        this.id = id;
        this.roomId = roomId;
        this.room = room;
        this.author = user;
        this.authorId = authorId;
        this.MsgText = Msg;
        this.dateTime = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return this.id;
    }

    public Long getAuthorId() {
        return this.authorId;
    }

    public Long getRoomId() {
        return this.roomId;
    }

    public String getContent() {
        return this.MsgText;
    }

    public void setTime(Timestamp time){
        this.dateTime = time;
    }

    public Timestamp getTime(){
        return this.dateTime;
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
        return "Message{" + "id=" +  this.id + ",\n"+ 
                "author={id=" + this.authorId + " ,login=" + "\"" +
                this.author.getLogin() + "\" ,password=\"" +
                this.author.getPassword() + "\" ,createdRooms=" +
                this.author.getCreatedRooms() + " ,rooms=" + this.author.getChatRooms() + "},\n" +
                "room={id=" + this.room.getId() + " ,name=" + "\"" +
                this.room.getRoomName() + "\" ,creator=null ,message=" +
                this.room.getMessages() + "},\n" +
                "text=\"" + this.getContent() + "\",\n" +
                "dateTime=" + this.getTime() + "\n}";
    }
}   
