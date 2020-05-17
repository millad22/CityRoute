package busses;

import java.util.Objects;
import java.util.Scanner;

/**
 * all methods that needed to print out the tables with information to the user
 */
public class Table {
    private static Network network = new Network(10, 2, 3);

    public static void printTable() {
        for (var station : network.getStations()) {
            System.out.print("Bus stop " + station.getID());
            System.out.print(" -> ");
            for (var path : station.getPaths()) {
                System.out.print(station.getID());
                System.out.print("(");
                if (path.weight < 10) {
                    System.out.print(" ");
                }
                System.out.print(path.weight);
                System.out.print(")  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //TODO enter stations where we start and end to find the shortest way
    public static void printShortestPath() {
        String userInput = new Scanner(System.in).nextLine().toUpperCase();
        Station from;
        Station to;
        System.out.println("From: ");
        
        while (true) {

            from = getInputAsId();
            System.out.println("wrong station name. Please try again: ");

            System.out.println("To: ");
            while (true) {
               to = getInputAsId();
                System.out.println("wrong station name. Please try again: ");

                System.out.println("\n" + network.shortestPath(from, to) + "\n");
            }
        }
    }

    //TODO user Input must be either accepted to operate with or ignored and asked to input the "char" that matches "bus sops ID"
    //"translate" user input string into the bus station char
    private static Station getInputAsId() {
        String stringToId = new Scanner(System.in).nextLine().toUpperCase();
        for(int i = 0; i < network.getStations().length; i++) {
            if (Objects.equals(network.getStations()[i].id, stringToId)) {
                return network.getStations()[i];
            }
        }
        return null;
    }
}
