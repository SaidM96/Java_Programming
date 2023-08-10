public class User{
    private Long                userID;
    private String              userLogin;
    private String              userPassword;
    private List<ChatRoom>      createdRooms;
    private List<ChatRoom>      chatrooms;


    public User(Long id, String login, String password) {
        this.userID = id;
        this.userLogin = login;
        this.userPassword = password;
    }

    // Getters and setters

    public Long getId() {
        return this.userID;
    }

    public String getLogin() {
        return this.userLogin;
    }

    public void setLogin(String login) {
        this.userLogin = login;
    }

    public String getPassword() {
        return this.userPassword;
    }

    public void setPassword(String password) {
        this.userPassword = password;
    }

    // hashCode()
    public int hashCode(){
        String code = "" + this.id;
        return (code.hashCode());
    }

    // equals()
    public boolean equals(User other){
        if (other && other.getId() == this.id)
            return true;
        return false;
    }

    // toString()
    public String toString(){
        return "User{" + "id=" + this.id + ", login='" + this.userLogin + '\'' + '}';
    }
}


public class ChatRoom{
    private Long          roomId;
    private Long          ownerId;
    private String        roomName;
    private List<Message> messages;
}

public class userChatRoom{
    private Long      user_id;
    private Long      chatroom_Id;
    private User      user;
    private ChatRoom  chatroom;
}

public class Message{
    private Long    id;
    private Long    roomId;
    private Long    authorId;
    private String  MsgText;
    private String  sendAt;
}   