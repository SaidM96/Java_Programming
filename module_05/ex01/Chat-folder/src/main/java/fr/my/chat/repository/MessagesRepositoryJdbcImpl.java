package fr.my.chat.repository;
import java.sql.*;
import java.util.List;
import java.util.Optional;

import com.zaxxer.hikari.HikariDataSource;

import fr.my.chat.models.ChatRoom;
import fr.my.chat.models.Message;
import fr.my.chat.models.User;

import java.util.LinkedList;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    
    private  HikariDataSource dataSource; // JBDC dataSource
    private Connection connection;

    public MessagesRepositoryJdbcImpl(HikariDataSource dataSource){
        this.dataSource = dataSource;
        try(Connection cnx = this.dataSource.getConnection()){
            this.connection = cnx;
            // this.databaseInit();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        
    }


    // public List<Message> findAll(){
    //     String query = "SELECT * FROM Message";
    //     List<Message> messages = new LinkedList<>();
    //     try (PreparedStatement stmt = this.connection.prepareStatement(query);
    //         ResultSet rs = stmt.executeQuery(query)){
    //         while(rs.next()){
    //             // Message msg = new Message(rs.getLong("id"), rs.getLong("roomId"), rs.getLong("authorId"), rs.getString("MsgText"));
    //             // msg.setTime(rs.getTimestamp("dateTime"));
    //             // messages.add(msg);
    //         }
    //         return messages;
    //     }
    //     catch(SQLException e) {
    //         e.printStackTrace();
    //         return new LinkedList<>();
    //     }
    // }

    // public void save(Message msg){
    //     String query = "INSERT INTO  Message" +
    //                     "VALUES(" + msg.getRoomId() + ", " + msg.getAuthorId() + ", " + msg.getContent() + ")";
    //     try(PreparedStatement stmt = this.connection.prepareStatement(query);
    //         ResultSet rs = stmt.executeQuery(query)){
    //     }
    //     catch(SQLException e){
    //         e.printStackTrace();
    //     }
    // }


    // public void delete(Message msg){
    //     String query = "DELETE FROM Mesasge WHERE id =" + msg.getId();
    //     try(PreparedStatement stmt = this.connection.prepareStatement(query);
    //         ResultSet rs = stmt.executeQuery(query)){
    //     }
    //     catch(SQLException e){
    //         e.printStackTrace();
    //     }
    // }


    // public void update(Message msg){
    //     String query = "UPDATE Message SET roomId=" +  msg.getRoomId() + ", authorId=" + msg.getAuthorId() + ", MsgText="  + msg.getContent() + "dateTime=" + msg.getTime() + " WHERE id =" + msg.getId();
    //     try(PreparedStatement stmt = this.connection.prepareStatement(query);
    //         ResultSet rs = stmt.executeQuery(query)){
            
    //     }
    //     catch(SQLException e){
    //         e.printStackTrace();
    //     }
    // }

    public Optional<Message> findById(Long id){
        String query = "SELECT * FROM Message WHERE id=" + id;
        try(PreparedStatement stmt = this.connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query)){
                if (rs.next()){
                    List<ChatRoom>  Rooms =  new LinkedList<>();
                    List<Message>   messages =  new LinkedList<>();

                    Message msg = new Message(rs.getLong("id"), 
                        new ChatRoom(8L,0L,"room", messages),
                        new User(7L, "user", "user",  Rooms, Rooms),
                        rs.getString("MsgText"));
                    msg.setTime(rs.getTimestamp("dateTime"));
                    return Optional.of(msg);
                }
                else
                    return Optional.empty();
        }
        catch(SQLException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
