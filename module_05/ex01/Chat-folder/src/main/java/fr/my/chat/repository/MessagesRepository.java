package fr.my.chat.repository;
import fr.my.chat.models.Message;
import java.util.Optional;

public interface MessagesRepository {
    Optional<Message> findById(Long id);
    // void delete(Message msg);
    // void save(Message msg);
    // void update(Message msg);
    // List<Message> findAll();
}