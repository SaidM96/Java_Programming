package ex04;
import java.util.UUID;
public class Program {
    public static void main(String[] args){
        try{
            TransactionsService transactionsService = new TransactionsService();
            User userA = transactionsService.AddUser("userA", 100);
            User userB = transactionsService.AddUser("userB", 100);
            User userC = transactionsService.AddUser("userC", 100);
            User userD = transactionsService.AddUser("userD", 100);
            User userE = transactionsService.AddUser("userE", 100);
            User userF = transactionsService.AddUser("userF", 100);
            System.out.println(userA.getName() + "has: " + userA.getBalance() + "$");
            System.out.println(userB.getName() + "has: " + userB.getBalance() + "$");
            System.out.println(userC.getName() + "has: " + userC.getBalance() + "$");
            System.out.println(userD.getName() + "has: " + userD.getBalance() + "$");
            System.out.println(userE.getName() + "has: " + userE.getBalance() + "$");
            System.out.println(userF.getName() + "has: " + userF.getBalance() + "$");
            UUID trId1 = transactionsService.PerformeTransaction(userA.getId(), userB.getId(), 50);
            UUID trId2 = transactionsService.PerformeTransaction(userC.getId(), userD.getId(), 50);
            UUID trId3 = transactionsService.PerformeTransaction(userE.getId(), userF.getId(), 50);
            System.out.println("after performing transactions: ");
            System.out.println(userA.getName() + " has: " + userA.getBalance() + "$");
            System.out.println(userB.getName() + " has: " + userB.getBalance() + "$");
            System.out.println(userC.getName() + " has: " + userC.getBalance() + "$");
            System.out.println(userD.getName() + " has: " + userD.getBalance() + "$");
            System.out.println(userE.getName() + " has: " + userE.getBalance() + "$");
            System.out.println(userF.getName() + " has: " + userF.getBalance() + "$");
            // check if  there any unpair transaction
            System.out.println("check if  there any unpair transaction: ");
            Transaction[] arr = transactionsService.checkValidityOfTransaction();
            for(int i = 0; i < arr.length; i++){
                System.out.println("unpair transaction " + arr[i].getId() + arr[i].getUserId());
            }
            // remove half transaction
            System.out.println("remove half transaction: ");
            transactionsService.removeTransaction(trId1, userA.getId());
            transactionsService.removeTransaction(trId2, userC.getId());
            transactionsService.removeTransaction(trId3, userF.getId());

            // check again and print 
            System.out.println("check again: ");
            Transaction[] arr1 = transactionsService.checkValidityOfTransaction();
            for(int i = 0; i < arr1.length; i++){
                System.out.println("unpair transaction " + arr1[i].getId());
            }
            // err
            transactionsService.PerformeTransaction(userA.getId(), userB.getId(), 50.01);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}