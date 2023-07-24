import java.util.UUID;

public class Program {
    public static void main(String[] args){
        User user1 = new User("user1", 100);
        User user2 = new User("user2", 100);
        Transaction tr1 = new Transaction(user1, user2, true);
        System.out.println(user1.GetName() + " Balance: " + user1.GetBalance());
        System.out.println(user2.GetName() + " Balance: " + user2.GetBalance());
        tr1.setTransaction(50);
        System.out.println(user1.GetName() + " Balance after: " + user1.GetBalance());
        System.out.println(user2.GetName() + " Balance after: " + user2.GetBalance());
        System.out.println(tr1.category);
    }
}

public class User {
    private UUID Identifier;
    private String Name;
    private double Balance;

    public User(String name, double bl){
        this.Identifier = UUID.randomUUID();
        this.Name = name;
        this.Balance = bl;
    }

    public double GetBalance(){
        return this.Balance;
    }

    public String GetName(){
        return this.Name;
    }

    public void setBalance(double balance){
        this.Balance = balance;
    }
}

public class Transaction {
    UUID                    Identifier;
    User                    Recipient;
    User                    Sender;
    boolean                 category; // false debits,  true credits
    double                  Amount;

    public boolean isValidTransaction(double amount){
        if (this.Sender.GetBalance() < amount )
            return false;
        return true;
    }

    public Transaction(User rcp, User send, boolean ctg){
        this.Identifier = UUID.randomUUID();
        this.Recipient = rcp;
        this.category = ctg;
        this.Sender = send;
    }

    void setTransaction(double amount){
        if (this.isValidTransaction(amount)){
            this.Sender.setBalance(this.Sender.GetBalance() - amount);
            this.Recipient.setBalance(this.Recipient.GetBalance() + amount);
        }
    }

    public User GetSender(){
        return this.Sender;
    }
    public User GetRecipient(){
        return this.Recipient;
    }
}