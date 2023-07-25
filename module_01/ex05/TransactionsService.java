package ex04;
import java.util.UUID;
public class TransactionsService {
    UsersList userList;
    TransactionsList unpairTransactions;
    public TransactionsService(){
        this.userList = new UsersArrayList();
        this.unpairTransactions = new TransactionsLinkedList();
    }

    public User AddUser(String name, double balance){
        User newUser = new User(name, balance);
        this.userList.addUser(newUser);
        return newUser;
    }

    public double getBalanceById(UUID id){
        User user = this.userList.getUserById(id);
        return user.getBalance();
    }

    public UUID PerformeTransaction(UUID senderId, UUID recieverId, double amount) throws IllegalTransactionException{
        UUID id = UUID.randomUUID();
        User sender = this.userList.getUserById(senderId);
        User receiver = this.userList.getUserById(recieverId);
        if (sender.getBalance() < amount)
            throw new IllegalTransactionException("IllegalTransactionException"); // throw sold insuffisant
        Transaction senderTransaction = new Transaction(id, senderId, recieverId, TransactionType.DEBIT, amount);
        Transaction receiverTransaction = new Transaction(id, recieverId, senderId, TransactionType.CREDIT, amount);
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);
        sender.transactions.AddTransaction(senderTransaction);
        receiver.transactions.AddTransaction(receiverTransaction);

        return senderTransaction.getId();
    }

    public Transaction[] getTransactionsHistory(UUID userId){
        User user = this.userList.getUserById(userId);
        return user.transactions.toArray();
    }

    public void removeTransaction(UUID transactionId, UUID userId)throws TransactionNotFoundException {
        User user = this.userList.getUserById(userId);
        user.transactions.RemoveTransaction(transactionId);
    }

    private boolean isValideTransaction(UUID transactionId, UUID userAId, UUID userBId){
        User userA = this.userList.getUserById(userAId);
        User userB = this.userList.getUserById(userBId);
        Transaction trA = userA.transactions.getTransactionById(transactionId);
        Transaction trB = userB.transactions.getTransactionById(transactionId);
        if (trA != null && trB != null && (trA.getType() != trB.getType()) && (trA.getAmount() == trB.getAmount())){
            return true;
        }
        return false;
    }

    public Transaction[] checkValidityOfTransaction(){
        User[] users = this.userList.getUsers();
        for(int i = 0; i < this.userList.size(); i++){
            Transaction[] transactions = users[i].transactions.toArray();
            for(int j = 0; j < transactions.length; j++){
                if (!this.isValideTransaction(transactions[j].getId(), transactions[j].getUserId(),transactions[j].getOtherUserId())){
                    this.unpairTransactions.AddTransaction(transactions[j]);
                }
            }
        }
        Transaction[] result = this.unpairTransactions.toArray();
        return (result);
    }
}