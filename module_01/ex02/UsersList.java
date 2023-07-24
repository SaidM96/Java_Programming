package ex02;

public interface UsersList {
    void addUser(User user);
    User getUserById(int id) throws UserNotFoundException;
    int getNumberOfUsers();
}