package ex04;
import java.util.UUID;
public interface TransactionsList{
    void AddTransaction(Transaction transaction);
    void RemoveTransaction(UUID id) throws TransactionNotFoundException;
    Transaction[] toArray();
}