package ex03;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    TransactionsList transactions;

    public User(String name){
        this.id = UUID.randomUUID();
        this.transactions = new TransactionsLinkedList();
        this.name = name;
    }

    public UUID getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
}