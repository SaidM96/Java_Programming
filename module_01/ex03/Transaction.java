package ex03;
import java.util.UUID;

public class Transaction{
    private UUID id;
    
    public Transaction(){
        this.id = UUID.randomUUID();
    }

    public UUID getId(){
        return this.id;
    }
}