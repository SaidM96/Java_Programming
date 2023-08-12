package fr.my.chat.models;

import java.util.LinkedList;
import java.util.List;

public class User{
    private Long                userID;
    private String              login;
    private String              userPassword;
    private List<ChatRoom>      createdRooms;
    private List<ChatRoom>      chatrooms;


    public User() {
        this.createdRooms = new LinkedList<>();
        this.chatrooms = new LinkedList<>();
    }
    
    public User(Long id, String login, String password, List<ChatRoom> createdRooms, List<ChatRoom> chatrooms) {
        this.userID = id;
        this.login = login;
        this.userPassword = password;
        this.createdRooms = createdRooms;
        this.chatrooms = chatrooms;
        this.createdRooms = createdRooms;
        this.chatrooms = chatrooms;
    }

    // Getters and setters

    public Long getId() {
        return this.userID;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
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
        return "User{" + "id=" + this.userID + ", login='" + this.login + '\'' + '}';
    }
}


