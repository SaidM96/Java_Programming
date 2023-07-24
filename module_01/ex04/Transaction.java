package ex04;
import java.util.UUID;

public class Transaction{
    private UUID id;
    private TransactionType type;
    private double amount;
    
    public Transaction(){
        this.id = UUID.randomUUID();
    }

    public UUID getId(){
        return this.id;
    }
}

enum TransactionType {
    DEBIT,
    CREDIT
}