package ex04;
import java.util.UUID;

public interface UsersList {
    void addUser(User user);
    User[] getUsers();
    int size();
    User getUserById(UUID id);
    int getNumberOfUsers();
}