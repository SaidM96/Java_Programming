package ex02;

public class Program {
    public static void main(String[] args){
        UsersList usersList = new UsersArrayList();
        // Adding users to the list
        User[] users = new User[100];
        for(int i = 0; i < 100; ++i){
            users[i] = new User("user" + i);
        }
        for(int i = 0; i < 100; ++i){
            usersList.addUser(users[i]);
        }
        try{
            for(int i = 0; i < 100; ++i){
                User user = usersList.getUserById(users[i].getId());
                User userB = usersList.getUserByIndex(i);
                System.out.println("usernameA: " + user.getName() + " id: " + user.getId());
                System.out.println("usernameB: " + userB.getName() + " idex: " + i);
            }
            // err  
            User x = usersList.getUserById(102);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        // Getting the number of users
        System.out.println("Number of users: " + usersList.getNumberOfUsers());
    }
}



