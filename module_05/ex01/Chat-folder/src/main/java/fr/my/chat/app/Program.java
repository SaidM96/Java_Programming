package fr.my.chat.app;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import fr.my.chat.models.Message;
import fr.my.chat.repository.MessagesRepositoryJdbcImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
public class Program {
    public static void main(String[] args){
        Long id = Long.valueOf(Integer.parseInt(args[0]));
        String jdbcUrl = "jdbc:postgresql://localhost:5432/MyDb";
        String pgUser = "postgres";
        String pgPass = "said123";
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(pgUser);
        config.setPassword(pgPass);
        HikariDataSource dataSource = new HikariDataSource(config);

        try(Connection connextion = dataSource.getConnection()){
            MessagesRepositoryJdbcImpl  repo = new MessagesRepositoryJdbcImpl(dataSource);
            Optional<Message> msg = repo.findById(id);
            System.out.println(msg.toString());
        }
        catch(SQLException e) {
            e.printStackTrace();
        }  
    }
}
