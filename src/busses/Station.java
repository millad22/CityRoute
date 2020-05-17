package busses;

import java.util.ArrayList;
import java.util.List;
/**
 * Station as an object (node)
 */
public class Station {
    public int length;
    private ArrayList<Edge> paths = new ArrayList<>();
    public char id;

    //private final char id;
    public char getID() {
        return this.id;
    }
    public Station(char id){
        this.id = id;
    }
    List<Edge> getPaths(){
        return this.paths;
    }
    void addPath(Station other, int weight){
        this.paths.add(new Edge(other, weight));
    }
}
