package busses;

import java.util.*;

/**
 * the names of stations are in form of an char array (A, B, C ect)
 * a list of stations as object
 */
public class Network {
    public static Station[] stations;

    Station[] getStations() {
        return this.stations;
    }

    /**
     * building the network of stations
     * here is a constructor so we can set up out network details: 10 stops, 2 minimum paths, 3 maximum paths
     */
    public Network(int stations, int minPath, int maxPath) {
        this.stations = new Station[stations];
        for (int i = 0; i < stations; i++) {
            this.stations[i] = new Station((char) ((int) 'A' + i));
        }
        this.generateRelations(minPath, maxPath); //call the method generateRelations to connect stations with paths
    }

    /**
     * method to build relations in the network
     */
    public void generateRelations(int minPath, int maxPath) {
        var length = this.stations.length;
        ArrayList<Integer>[] relations = new ArrayList[length];
        ArrayList<Integer>[] available = new ArrayList[length];
        var notReady = new ArrayList<Integer>(length); //the stations is not having at least 2 edges yet
        var notIntegrated = new ArrayList<Integer>(length); //the stations not connected yet
        for (int i = 0; i < length; i++) {
            notReady.add(i);
            notIntegrated.add(i);
            relations[i] = new ArrayList<>();
            available[i] = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    available[i].add(j);
                }
            }
        }

        var network = this;
        var relater = new Relater() {
            public void addPath(Integer a, Integer b, int weight) {
                relations[a].add(b);
                network.stations[a].addPath(network.stations[b], weight);
                if (relations[a].size() == maxPath) {
                    for (int i = 0; i < length; i++) {
                        available[i].removeIf(x -> x == a);
                    }
                } else {
                    available[a].removeIf(x -> x == b);
                    if (relations[a].size() == minPath) {
                        notReady.removeIf(x -> x == a);
                    }
                }
            }
        };

        /**
         * random variable for the connection between the stations
         * do while the connections are completed till the circle
         * listA - bus stops, listB - bus stops connected to the listA
         */
        var random = new Random();
        do {
            var listA = (notIntegrated.size() > 0) ? notIntegrated : notReady;
            var a = listA.get(random.nextInt(listA.size()));
            var listB = available[a];
            if (listA == notIntegrated && listA.size() < length) {
                listB = new ArrayList<>(listB);
                listB.removeIf(listA::contains); //method reference
            }
            var b = listB.get(random.nextInt(listB.size()));
            if (listA == notIntegrated) {
                listA.removeIf(x -> x == a);
                listA.removeIf(x -> x == b);
            }
            int weight = 1 + random.nextInt(10); //each edge weight is from 1 to 10
            relater.addPath(a, b, weight); //connecting stations, method addPath
            relater.addPath(b, a, weight);
        }
        while (notReady.size() > 0);
    }

    //TODO dijkstra algorithm

    /**
     * implementing Dijkstra algorithm to find the shortest path between the start and end stations
     * @return
     */
    public int shortestPath(Station from, Station to) {
        

        int distance = 0;
        return distance;
    }

    public void addLine(char a, char a1, int cost) {
    }

    public void getShortestPath(char a, char a1) {

    }
}
