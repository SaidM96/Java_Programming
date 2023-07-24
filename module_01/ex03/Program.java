package ex03;

public class Program {
    public static void main(String[] args){
        User user = new User("Said");
        Transaction tr1  = new Transaction();
        Transaction tr2  = new Transaction();
        Transaction tr3  = new Transaction();
        Transaction tr4  = new Transaction();
        Transaction tr5  = new Transaction();
        Transaction tr6  = new Transaction();

        user.transactions.AddTransaction(tr1);
        user.transactions.AddTransaction(tr2);
        user.transactions.AddTransaction(tr3);
        user.transactions.AddTransaction(tr4);
        user.transactions.AddTransaction(tr5);
        user.transactions.AddTransaction(tr6);
        Transaction[] arr1 = user.transactions.toArray();
        for(int i = 0; i < arr1.length; i++){
            System.out.println(arr1[i]);
        }
        try{
            user.transactions.RemoveTransaction(tr1.getId());
            user.transactions.RemoveTransaction(tr2.getId());
            user.transactions.RemoveTransaction(tr3.getId());
            Transaction[] arr2 = user.transactions.toArray();
            for(int i = 0; i < arr2.length; i++){
                System.out.println(arr2[i]);
            }
            // err;
            user.transactions.RemoveTransaction(tr3.getId());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}











