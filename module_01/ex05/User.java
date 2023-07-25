package ex05;
import java.util.UUID;

public class User {
    private int id;
    private String name;
    private double balance;
    TransactionsList transactions;


    public User(String name, double balance){
        this.id = UserIdsGenerator.getInstance().generateId();
        this.transactions = new TransactionsLinkedList();
        this.name = name;
        this.balance = balance;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getBalance(){
        return this.balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }
}