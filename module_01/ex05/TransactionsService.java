package ex05;
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

    public double getBalanceById(int id){
        User user = this.userList.getUserById(id);
        return user.getBalance();
    }

    public User getUserById(int id){
        User user = this.userList.getUserById(id);
        return user;
    }

    public UUID PerformeTransaction(int senderId, int recieverId, double amount) throws IllegalTransactionException{
        UUID id = UUID.randomUUID();
        User sender = this.userList.getUserById(senderId);
        User receiver = this.userList.getUserById(recieverId);
        if (sender == null || receiver == null)  throw new IllegalTransactionException("no such user");
        if (sender.getBalance() < amount)
            throw new IllegalTransactionException("IllegalTransactionException : sold insuffisant");
        Transaction senderTransaction = new Transaction(id, senderId, recieverId, TransactionType.DEBIT, amount);
        Transaction receiverTransaction = new Transaction(id, recieverId, senderId, TransactionType.CREDIT, amount);
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);
        sender.transactions.AddTransaction(senderTransaction);
        receiver.transactions.AddTransaction(receiverTransaction);
        return senderTransaction.getId();
    }

    public Transaction[] getTransactionsHistory(int userId){
        User user = this.userList.getUserById(userId);
        return user.transactions.toArray();
    }

    public void removeTransaction(UUID transactionId, int userId)throws TransactionNotFoundException {
        User user = this.userList.getUserById(userId);
        user.transactions.RemoveTransaction(transactionId);
    }

    private boolean isValideTransaction(UUID transactionId, int userAId, int userBId){
        User userA = this.userList.getUserById(userAId);
        User userB = this.userList.getUserById(userBId);
        Transaction trA = userA.transactions.getTransactionById(transactionId);
        Transaction trB = userB.transactions.getTransactionById(transactionId);
        if (trA != null && trB != null && (trA.getType() != trB.getType()) && (trA.getAmount() == trB.getAmount()))
            return true;
        return false;
    }

    public Transaction[] checkValidityOfTransaction(){
        this.unpairTransactions.clear();
        User[] users = this.userList.getUsers();
        for(int i = 0; i < this.userList.size(); i++){
            Transaction[] transactions = users[i].transactions.toArray();
            for(int j = 0; j < users[i].transactions.size(); j++){
                if (this.isValideTransaction(transactions[j].getId(), transactions[j].getUserId(),transactions[j].getOtherUserId()) == false){
                    this.unpairTransactions.AddTransaction(transactions[j]);
                }
            }
        }
        Transaction[] result = this.unpairTransactions.toArray();
        return (result);
    }
}