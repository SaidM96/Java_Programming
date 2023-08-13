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
        String dbUser = "said";
        String dbPass = "said123";
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(dbUser);
        config.setPassword(dbPass);
        HikariDataSource dataSource = new HikariDataSource(config);
        MessagesRepositoryJdbcImpl  repo = new MessagesRepositoryJdbcImpl(dataSource);
        Optional<Message> msg = repo.findById(id);
        System.out.println(msg.toString()); 
    }
}
