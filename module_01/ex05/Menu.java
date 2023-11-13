package ex05;
import java.util.UUID;
import java.util.Scanner;
public class Menu {
    private TransactionsService service;
    private String commands = new String("1. Add a user\n2. View user balances\n3. Perform a transfer\n4. View all transactions for a specific user\n5. DEV - remove a transfer by ID\n6. DEV - check transfer validity\n7. Finish execution");

    public Menu(){
        this.service = new TransactionsService();
    }

    public void startProgram(){
        while(true){
            System.out.println(this.commands);
            Scanner in = new Scanner(System.in);
            int numCmd = 0;
            try {
                if (!in.hasNextInt()) throw new IllegalTransactionException("please enter a valid number command");
                numCmd = in.nextInt();
            }
            catch(Exception e){
                if (e instanceof IllegalTransactionException)
                    System.out.println(e.getMessage());
                else
                    System.out.println("please enter a valid number command");
            }
            if (numCmd == 1){
                try {
                    System.out.println("Enter a user name and a balance");
                    Scanner inSwitch = new Scanner(System.in);
                    if (!inSwitch.hasNextLine()) throw new IllegalTransactionException("please enter a user name and  balance");
                    String cmd = inSwitch.nextLine();
                    String[] params = cmd.split(" ");
                    if (params.length != 2) throw new IllegalTransactionException("please enter a valid  user name and  balance");
                    String name = params[0];
                    int balance = Integer.parseInt(params[1]);
                    if (name.length() > 1 && balance >= 0){
                        User user = this.service.AddUser(name, balance);
                        System.out.println("User with id = " + user.getId() + " is added");
                    }
                }
                catch(Exception e){
                    if (e instanceof IllegalTransactionException)
                        System.out.println(e.getMessage());
                    else
                        System.out.println("please enter a valid user name and  balance");
                }
            }
            else if (numCmd == 2){
                try {
                    System.out.println("Enter a user ID");
                    Scanner inSwitch = new Scanner(System.in);
                    if (!inSwitch.hasNextInt()) throw new IllegalTransactionException("please enter a valid user ID");
                    int id = inSwitch.nextInt();
                    User user = this.service.getUserById(id);
                    if (user == null) throw new IllegalTransactionException("no such user with Id: " + id);
                    System.out.println(user.getName() + " - " + user.getBalance());
                }
                catch(Exception e){
                    if (e instanceof IllegalTransactionException)
                        System.out.println(e.getMessage());
                    else
                        System.out.println("please enter a valid user ID");
                }
            }
            else if (numCmd == 3){
                try{
                    System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
                    Scanner inSwitch = new Scanner(System.in);
                    String cmd = inSwitch.nextLine();
                    String[] params = cmd.split(" ");
                    int senderId = Integer.parseInt(params[0]);
                    int receiverId = Integer.parseInt(params[1]);
                    double amount = Integer.parseInt(params[2]);
                    this.service.PerformeTransaction(senderId, receiverId, amount);
                    System.out.println("The transfer is completed");
                }
                catch(Exception e){
                    if (e instanceof IllegalTransactionException)
                        System.out.println(e.getMessage());
                    else
                        System.out.println("please enter a valid Transaction : sender ID, a recipient ID, and a transfer amount");
                }
            }
            else if (numCmd == 4){
                try {
                    System.out.println("Enter a user ID");
                    Scanner inSwitch = new Scanner(System.in);
                    int id = inSwitch.nextInt();
                    User user = this.service.getUserById(id);
                    if (user == null) throw new IllegalTransactionException("no such user with ID: " + id);
                    Transaction[] trs = this.service.getTransactionsHistory(id);
                    for(int i = 0; i < trs.length; i++){
                        User otherUser = this.service.getUserById(trs[i].getOtherUserId());
                        if (trs[i].getType() == TransactionType.CREDIT){
                            System.out.println("From " + otherUser.getName() + "(id = " + otherUser.getId() + ") " + "+" + trs[i].getAmount() + " with id = " + trs[i].getId());
                        }
                        else{
                            System.out.println("To " + otherUser.getName() + "(id = " + otherUser.getId() + ") " + "-" + trs[i].getAmount() + " with id = " + trs[i].getId());
                        }
                    }
                }
                catch (Exception e){
                    if (e instanceof IllegalTransactionException)
                        System.out.println(e.getMessage());
                    else
                        System.out.println("please enter a valid user ID");
                }
            }
            else if (numCmd == 5){
                try{
                    System.out.println("Enter a user ID and a transfer ID");
                    Scanner inSwitch = new Scanner(System.in);
                    String cmd = inSwitch.nextLine();
                    String[] params = cmd.split(" ");
                    int id = Integer.parseInt(params[0]);
                    User user = this.service.getUserById(id);
                    if (user == null) throw new IllegalTransactionException("no such user with ID: " + id);
                    UUID trId = UUID.fromString(params[1]);
                    Transaction[] transactions = this.service.getTransactionsHistory(id);
                    Transaction deletedTr = null;
                    for(int i = 0; i < transactions.length; i++){
                        if (trId.equals(transactions[i].getId()))
                            deletedTr = transactions[i];
                    }
                    if (deletedTr == null){
                        throw new IllegalTransactionException(user.getName() + " has no transaction with uuid: " + trId);
                    }
                    User otherUser = this.service.getUserById(deletedTr.getOtherUserId());
                    if (deletedTr.getType() == TransactionType.CREDIT){
                        System.out.println("Transfer From " + otherUser.getName() + "(id = " + otherUser.getId() + ") " +  deletedTr.getAmount() +  " removed");
                    }
                    else{
                        System.out.println("Transfer To " + otherUser.getName() + "(id = " + otherUser.getId() + ") " +  deletedTr.getAmount() +  " removed");
                    }
                    this.service.removeTransaction(trId, id);
                }
                catch(Exception e){
                    if (e instanceof IllegalTransactionException)
                        System.out.println(e.getMessage());
                    else
                        System.out.println("invalid user ID and a transfer ID");
                }
            }
            else if (numCmd == 6){
                System.out.println("Check results:");
                Transaction[] unpairTransactions = this.service.checkValidityOfTransaction();
                int unpairsLength = this.service.unpairTransactions.size();
                for(int i = 0; i < unpairsLength; i++){
                    User user = this.service.getUserById(unpairTransactions[i].getUserId());
                    User otherUser = this.service.getUserById(unpairTransactions[i].getOtherUserId());
                    if (unpairTransactions[i].getType() == TransactionType.CREDIT){
                        System.out.println(user.getName() + "(id = " + user.getId() + ") has an unacknowledged transfer id = " + unpairTransactions[i].getId() + " from " + otherUser.getName() + "(id = " + otherUser.getId() + ") for " + unpairTransactions[i].getAmount());
                    }
                    else{
                        System.out.println(user.getName() + "(id = " + user.getId() + ") has an unacknowledged transfer id = " + unpairTransactions[i].getId() + " to " + otherUser.getName() + "(id = " + otherUser.getId() + ") for " + unpairTransactions[i].getAmount());
                    }
                }
            }
            else if (numCmd == 7){
                System.exit(0);
            }
            else
                System.out.println("invalid command");
            System.out.println("---------------------------------------------------------");
        }
    }
}