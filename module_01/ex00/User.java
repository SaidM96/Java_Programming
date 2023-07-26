package ex00;
import java.util.UUID;

public class User {
    private UUID Identifier;
    private String Name;
    private double Balance;

    public User(String name, double bl){
        this.Identifier = UUID.randomUUID();
        this.Name = name;
        this.Balance = bl;
    }

    public double GetBalance(){
        return this.Balance;
    }

    public String GetName(){
        return this.Name;
    }

    public void setBalance(double balance){
        this.Balance = balance;
    }
}