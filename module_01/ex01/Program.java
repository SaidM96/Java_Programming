package ex01;

public class Program {
    public static void main(String[] args){
        User userA = new User("Said");
        User userB = new User("anas");
        User userC = new User("ahmed");

        System.out.println(userA.getName() + " id: " + userA.getId());
        System.out.println(userB.getName() + " id: " + userB.getId());
        System.out.println(userC.getName() + " id: " + userC.getId());
    }
}