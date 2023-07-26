package ex00;
import java.util.UUID;

public class Transaction {
    UUID                    Identifier;
    User                    Recipient;
    User                    Sender;
    boolean                 category;
    double                  Amount;

    public boolean isValidTransaction(double amount){
        if ((this.category &&  amount > 0) || (!this.category && amount < 0))
            return false;
        if (this.Sender.GetBalance() < amount )
            return false;
        return true;
    }

    public Transaction(User send, User rcp, boolean ctg){
        this.Identifier = UUID.randomUUID();
        this.Recipient = rcp;
        this.category = ctg;
        this.Sender = send;
    }

    boolean setTransaction(double amount){
        if (this.isValidTransaction(amount)){
            this.Sender.setBalance(this.Sender.GetBalance() - amount);
            this.Recipient.setBalance(this.Recipient.GetBalance() + amount);
            return true;
        }
        return false;
    }

    public User GetSender(){
        return this.Sender;
    }
    public User GetRecipient(){
        return this.Recipient;
    }
    public boolean getCategory(){
        return this.category;
    }
}