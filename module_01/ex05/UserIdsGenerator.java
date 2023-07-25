package ex05;

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