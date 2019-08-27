package components;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Boundary extends Coordinate{
    public Boundary(int[] maxDimensions) throws Exception {
        super(maxDimensions);
    }

    public Map<Coordinate, Cell> generateInitialTopology(World world) {
        Map<Coordinate, Cell> topology = new ConcurrentHashMap<>();
        for ( int i = 0; i < this.x; i++ ) {
            for ( int j = 0; j < this.y; j++ ) {
                Coordinate coordinates = new Coordinate(i, j);
                Cell cell = new Cell(world, coordinates);
                topology.put(coordinates, cell);
            }
        }
        return topology;
    }
}
