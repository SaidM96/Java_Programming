package ex04;
import java.util.UUID;

public class Transaction{
    private UUID id;
    private UUID userId;
    private UUID otherId;
    private TransactionType type;
    private double amount;
    
    public Transaction(UUID id, UUID userId,UUID otherId, TransactionType type, double amount){
        this.id = id;
        this.otherId = otherId;
        this.userId = userId;
        this.type = type;
        this.amount = amount;
    }

    public UUID getId(){
        return this.id;
    }

    public UUID getUserId(){
        return this.userId;
    }

    public UUID getOtherUserId(){
        return this.otherId;
    }

    public double getAmount(){
        return this.amount;
    }

    public TransactionType getType(){
        return this.type;
    }

    // setter
    public void setUserId(UUID id){
        this.userId = id;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public void setType(TransactionType type){
        this.type = type;
    }

    // 
}

