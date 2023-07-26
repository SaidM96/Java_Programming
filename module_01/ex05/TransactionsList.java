package ex05;
import java.util.UUID;
public interface TransactionsList{
    void AddTransaction(Transaction transaction);
    void RemoveTransaction(UUID id) throws TransactionNotFoundException;
    Transaction getTransactionById(UUID transactionId);
    Transaction[] toArray();
    int size();
    void clear();
}