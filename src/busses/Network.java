package busses;

import java.util.ArrayList;
import java.util.Random;
/**
 * the Network to build connection between stations
 * Stations in a char list
 * Network constructor
 */
class Network {
    private Station[] stations;
    Station[] getStations(){
        return this.stations;
    }
    Network(int stations, int minPaths, int maxPaths) {
        this.stations = new Station[stations];
        for (int i = 0; i < stations; i++) {
            this.stations[i] = new Station((char) ((int)'A' + i));
        }
        this.generateRelations(minPaths, maxPaths);
    }
    /**
     * method to generate relations
     * @param minPaths = 2
     * @param maxPaths = 3
     */
    private void generateRelations(int minPaths, int maxPaths) {
        var length = this.stations.length;
        ArrayList<Integer>[] relations = new ArrayList[length];
        ArrayList<Integer>[] available = new ArrayList[length];
        var notReady = new ArrayList<Integer>(length);
        var notIntegrated = new ArrayList<Integer>(length);
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
        /**
         * network as an object
         * amount of relations from 2 to 3
         */
        Network network = this;
        Relator relator = (a, b, weight) -> { //relation object replaced with Lambda
            relations[a].add(b);
            network.stations[a].addPath(network.stations[b], weight);
            if (relations[a].size() == 3) {
                for (int i=0; i < length; i++) {
                    available[i].removeIf(x -> x == a);
                }
            }
            else {
                available[a].removeIf(x -> x == b);
                if (relations[a].size() == 2) {
                    notReady.removeIf(x -> x == a);
                }
            }
        };
        /**
         * random variable for the connection between the stations
         * do while the connections are completed till the circle
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
                listA.removeIf(x -> x.equals(a));
                listA.removeIf(x -> x.equals(b));
            }
            var weight = 1 + random.nextInt(10);
            relator.addPath(a, b, weight);
            relator.addPath(b, a, weight);
        }
        while (notReady.size() > 0);
    }
}
