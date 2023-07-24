import java.util.UUID;

public class User {
    UUID Identifier;
    String Name;
    double Balance;

    public User(String name, double bl){
        this.Identifier = UUID.randomUUID();
        this.Name = name;
        this.Balance = bl;
    }

    public double getBalance(){
        return this.Balance;
    }

    public String GetName(){
        return this.Name;
    }

    public void setBalance(balance){
        this.Balance = balance;
    }
}