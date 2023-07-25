package ex05;

public class Menu {
    private TransactionsService service;
    String commands = new String("1. Add a user\n2. View user balances\n3. Perform a transfer\n4. View all transactions for a specific user\n5. DEV - remove a transfer by ID\n6. DEV - check transfer validity\n7. Finish execution");

    public Menu(){
        this.service = new TransactionsService();
    }


}