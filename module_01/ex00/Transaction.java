import java.util.UUID;

public class Transaction {
    UUID                    Identifier;
    User                    Recipient;
    User                    Sender;
    boolean                 category; // false debits,  true credits
    double                  Amount;

    public boolean isValidTransaction(double amount){
        if (this.Sender.getBalance() < amount )
            return false;
        return true;
    }

    public Transaction(User rcp, User send){
        this.Identifier = UUID.randomUUID();
        this.Recipient = rcp;
        this.Sender = send;
    }

    void setTransaction(double amount){
        if (this.isValidTransaction(amount)){
            this.Sender.setBalance(this.getBalance() - amount);
            this.Recipient.setBalance(this.getBalance() + amount);
        }
    }

    public User GetSender(){
        return this.Sender;
    }
    public User GetRecipient(){
        return this.Recipient;
    }
}