
public class Program {
    public static void main(String[] args){
        UsersList usersList = new UsersArrayList();
        // Adding users to the list
        User[] users = new User[100];
        for(int i = 0; i < 100; ++i){
            users[i] = new User("user" + i);
        }
        for(int i = 0; i < 100; ++i){
            usersList.addUser(users[i]);
        }
        try{
            for(int i = 0; i < 100; ++i){
                User user = usersList.getUserById(users[i].getId());
                System.out.println("username: " + user.getName() + " id: " + user.getId());
            }
            // err  
            User x = usersList.getUserById(102);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        // Getting the number of users
        int numberOfUsers = usersList.getNumberOfUsers();
        System.out.println("Number of users: " + numberOfUsers);
    }
}


public class UserIdsGenerator{
    private int id;
    private static UserIdsGenerator instance;

    public static synchronized UserIdsGenerator getInstance(){
        if (instance == null)
            instance = new UserIdsGenerator();
        return instance;
    }

    private UserIdsGenerator(){
        this.id = 0;
    }

    public int generateId(){
        this.id += 1;
        return this.id;
    }
}

public class User {
    private int id;
    private String name;

    public User(String name){
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
}

public interface UsersList {
    void addUser(User user);
    User getUserById(int id) throws UserNotFoundException;
    int getNumberOfUsers();
}

public class UsersArrayList implements UsersList{
    private User[] _users;
    private int _size;
    private int _capacity;

    public UsersArrayList(){
        this._capacity = 10;
        this._size = 0;
        this._users = new User[_capacity];
    }

    private void reserve(int newCap){
        User[] newUsers = new User[newCap];
        for(int i = 0; i < this._size; ++i){
            newUsers[i] = this._users[i];
        }
        this._users = newUsers;
        this._capacity = newCap;
    }

    public void addUser(User user){
        if (this._size < this._capacity)
            this._users[this._size] = user;
        else{
            this.reserve(this._capacity + (this._capacity / 2));
            this._users[this._size] = user;
        }
        this._size++;
    }

    public User getUserById(int id) throws UserNotFoundException{
        for(int i = 0; i < this._size; ++i){
            if (this._users[i].getId() == id)
                return this._users[i];
        }
        throw new UserNotFoundException("no such user with the id: " + id);
    }

    public int getNumberOfUsers(){
        return this._size;
    }
}

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}