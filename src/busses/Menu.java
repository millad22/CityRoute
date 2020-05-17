package busses;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

class Menu extends IOException {
    private int userInput = 0;
    void printMenu() {
        System.out.println("[1] Check the bus routs\n" +
                "[2] Search for a shortest way from one stop to another\n" +
                "[3] Exit system.");
    }
    void displayMenu() {
        do {
            try {
                Scanner input = new Scanner(System.in);
                printMenu();
                userInput = input.nextInt();
                switch (userInput) {
                    case 1:
                        Table.printTable();
                        break;
                    case 2:
                        Table.printShortestPath();
                        break;
                    case 3:
                        System.out.println("----------"); //The session is finished in total
                        break;
                    default:
                        System.out.println();
                        System.out.println("The choice is invalid. Please try again");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Wrong input. Please try again"); //if we press invalid button
            }
        } while (userInput != 3); // the main menu frame reopens when the sessions finish after the end of each case
    }
}
