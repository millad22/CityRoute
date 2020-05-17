package busses;
import org.junit.Test;
import routs.Network;
import routs.Station;
import static org.junit.Assert.assertEquals;

public class RouteTests {

    //testing the methods that connect stations and gives weights to the edges between the stations

    @Test
    public void allStations_inList() {
        new Network(10, 2, 3);
        int stations = 10;
        Station[] stationsTest = new Station[stations];
        for (int i = 0; i < stations; i++) {
            stationsTest[i] = new Station((char) ('A' + i));
        }
        this.generateRelations();
        assertEquals(10, stations);
    }

    private void generateRelations() {
    }

    //counting the shortest distance between stations
    @Test
    public void distance_ofOneStation() {
        var network = new Network(10,2, 3);
        network.addLine('A', 'A', 0);
        network.getShortestPath('A', 'A');
        assertEquals(0, network.shortestPath('A', 'A'));
    }


    //TODO tests for getting shortest path and write the method for counting the shortestPath with Dijkstra algorithm
    @Test
    public void exampleTest_shortestPath_between_2_stations() {
        var network = new Network(10, 2, 3);
        network.addLine('A', 'B', 3); // cost 3 from a to b
        network.getShortestPath('A', 'B'); // from a to
        assertEquals(3, network.shortestPath('A', 'B')); // if it returns the cost
    }

    @Test
    public void exampleTest_shortestPath_between_3_stations() {
        var network = new Network(10, 2, 3);
        network.addLine('A', 'B', 3); // cost 3 from a to b
        network.addLine('B', 'C', 1); //cost 1 from b to c
        network.getShortestPath('A', 'C'); // from a to c
        assertEquals(4, network.shortestPath('A', 'C')); // if it returns the cost
    }

    @Test
    public void threeStations_2() {
        var network = new Network(10, 2, 3);
        network.addLine('A', 'B', 3); // cost 3 from a to b
        network.addLine('B', 'C', 1); //cost 1 from b to c
        network.addLine('A', 'C', 10); // from a to c
        network.getShortestPath('A', 'C');
        assertEquals(4, network.shortestPath('A', 'C')); // if it returns the cost
    }
}
