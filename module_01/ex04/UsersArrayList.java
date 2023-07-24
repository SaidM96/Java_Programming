package ex04;

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

