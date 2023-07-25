package ex04;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private double balance;
    TransactionsList transactions;


    public User(String name, double balance){
        this.id = UUID.randomUUID();
        this.transactions = new TransactionsLinkedList();
        this.name = name;
        this.balance = balance;
    }

    public UUID getId(){
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