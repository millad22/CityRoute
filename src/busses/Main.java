package busses;

/**
 * main class, start the program
 */
public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to Bus-Carabas! Enjoy your trips with us!\n" +
                "Here you check the network and find the shortest way to work");
        System.out.println();
        new Menu().displayMenu();
    }
}