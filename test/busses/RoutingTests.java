package busses;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoutingTests {

    @Test
    void oneNode_zeroDistance() {
        final BussStopGraph graph = new BussStopGraph("A");

        final int distance = graph.shortestDistanceBetween("A", "A");

        assertEquals(0, distance);
    }

    @Test
    void twoNodes_passBetween_equalWeight(){
        final BussStopGraph graph = new BussStopGraph("A", "B");
        graph.addNeighbor("A", "B", 1);

        final int distance = graph.shortestDistanceBetween("A", "B");

        assertEquals(1, distance);
    }

    @Test
    void threeNodes_passAll_eualSum(){
        final BussStopGraph graph = new BussStopGraph("A", "B", "C");
        graph.addNeighbor("A", "B", 1);
        graph.addNeighbor("B", "C", 3);

        final int distance = graph.shortestDistanceBetween("A","C");

        assertEquals(4, distance);
    }


}
