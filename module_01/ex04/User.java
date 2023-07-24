package ex04;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private double balance;
    TransactionsList transactions;


    public User(String name){
        this.id = UUID.randomUUID();
        this.transactions = new TransactionsLinkedList();
        this.name = name;
        this.balance = 0;
    }

    public UUID getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
}