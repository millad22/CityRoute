package busses;

import java.util.ArrayList;
import java.util.List;
/**
 * Station names as char
 * the list of the paths
 * getters for station ID, paths
 */
class Station {
    private ArrayList<Edge> paths = new ArrayList<>();
    private char id;
    char getID(){
        return this.id;
    }
    Station(char id){
        this.id = id;
    }
    List<Edge> getPaths(){
        return this.paths;
    }
    void addPath(Station other, int weight){
        this.paths.add(new Edge(other, weight));
    }
}
