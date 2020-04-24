package busses;

import java.util.Arrays;
import java.util.List;

public class BussStopGraph {


    private final Integer[][] neighbors;
    private final List<String> stops;

    public BussStopGraph(String... stops) { //... is Strings translated to an Array
        this.stops = Arrays.asList(stops); // "stops" are the nodes
        final int numberOfStops = stops.length;
        neighbors = new Integer[numberOfStops][];
        for (int i = 0; i < numberOfStops; i++) {
            neighbors[i] = new Integer[numberOfStops];
            neighbors[i][i] = 0;
        }
    }

    public void addNeighbor(String stop1, String stop2, int cost) {
        final int stop1Index = stops.indexOf(stop1);
        final int stop2Index = stops.indexOf(stop2);

        neighbors[stop1Index][stop2Index] = cost;
        neighbors[stop2Index][stop1Index] = cost;
    }

    public int shortestDistanceBetween(String start, String end) {
        int shortestDistance = 0;
        return shortestDistance;

        //needs to continue
    }



    //find the shortest distance, doesn't work yet. Needs the code


}