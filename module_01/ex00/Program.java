package ex00;
import java.util.UUID;

public class Program {
    public static void main(String[] args){
        User user1 = new User("user1", 100);
        User user2 = new User("user2", 100);
        // transaction debit for user1
        Transaction tr1 = new Transaction(user1, user2, false);
        System.out.println(user1.GetName() + " Balance: " + user1.GetBalance());
        System.out.println(user2.GetName() + " Balance: " + user2.GetBalance());
        System.out.println("transaction debit for user1: ");
        if(!tr1.setTransaction(50))
            System.out.println("invalid transaction");
        System.out.println(user1.GetName() + " Balance after transaction: " + user1.GetBalance());
        System.out.println(user2.GetName() + " Balance after transaction: " + user2.GetBalance());
        //er
        if(!tr1.setTransaction(-50))
            System.out.println("invalid transaction");
        if(!tr1.setTransaction(500))
            System.out.println("invalid transaction");
        // transaction credit for user1
        Transaction tr2 = new Transaction(user1, user2, true);
        System.out.println("transaction credit for user1: ");
        if(!tr2.setTransaction(-50))
            System.out.println("invalid transaction");
        System.out.println(user1.GetName() + " Balance after: " + user1.GetBalance());
        System.out.println(user2.GetName() + " Balance after: " + user2.GetBalance());
        if(!tr2.setTransaction(50))
            System.out.println("invalid transaction");
        if(!tr2.setTransaction(500))
            System.out.println("invalid transaction");
    }
}