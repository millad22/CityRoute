package busses;

/**
 * Edge(path) weight between stations settings
 * getter and constructor
 */
public class Edge {
    Station station;
    int weight;
    Edge(Station station, int weight) {
        this.station = station;
        this.weight = weight;
    }
    public Station getStation() {
        return this.station;
    }
    public int getWeight() {
        return this.weight;
    }
}
