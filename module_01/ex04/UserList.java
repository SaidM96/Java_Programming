package ex04;

public interface UsersList {
    void addUser(User user);
    User getUserById(int id) throws UserNotFoundException;
    double getUserBalance(int id);
    int getNumberOfUsers();
}