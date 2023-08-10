package fr.my.chat;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class User{
    private Long                userID;
    private String              userLogin;
    private String              userPassword;
    private List<ChatRoom>      createdRooms = new LinkedList<>();
    private List<ChatRoom>      chatrooms = new LinkedList<>();


    public User() {
    }
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

    public List<ChatRoom> getChatRooms(){
        return this.chatrooms;
    }

    public List<ChatRoom> getCreatedRooms(){
        return this.createdRooms;
    }

    // hashCode
    public int hashCode(){
        String code = "" + this.userID;
        return (code.hashCode());
    }

    // equals
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj != null){
            User user = (User) obj;
            if (user.getId() == this.userID)
                return true;
        }
        return false;
    }

    // toString()
    public String toString(){
        return "User{" + "id=" + this.userID + ", login='" + this.userLogin + '\'' + '}';
    }
}


