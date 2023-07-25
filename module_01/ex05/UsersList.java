package ex05;
import java.util.UUID;

public interface UsersList {
    void addUser(User user);
    User[] getUsers();
    int size();
    User getUserById(int id);
    int getNumberOfUsers();
}