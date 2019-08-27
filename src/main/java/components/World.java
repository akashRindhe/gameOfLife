package components;

import java.util.List;
import java.util.Map;

public class World {
    private final Map<Coordinate, Cell> coordinateCellMap;

    public World( int[] coordinateSize ) throws Exception {
        Boundary boundary = new Boundary(coordinateSize);
        this.coordinateCellMap = boundary.generateInitialTopology(this);
    }


    public int getLiveNeighbourCountFromList( List<Coordinate> coordinates ) {
        int count = 0;
        for ( Coordinate coordinate: coordinates ) {
            final Cell cell = coordinateCellMap.get( coordinate );
            if ( cell != null && cell.isLiving() ) {
                count++;
            }
        }
        return count;
    }


    public boolean isCellAtCoordinateAlive( Coordinate coordinate ) {
        return this.coordinateCellMap.get(coordinate).isLiving();
    }

    public void setLivingAt(Coordinate coordinate) {
        synchronized (this.coordinateCellMap) {
            this.coordinateCellMap.get(coordinate).setLiving();
        }
    }

    public void setDeadAt(Coordinate coordinate) {
        synchronized (this.coordinateCellMap) {
            this.coordinateCellMap.get(coordinate).setDead();
        }
    }

    public synchronized void tick() {
        for ( Cell cell : this.coordinateCellMap.values() ) {
            cell.calculateStateInNextGeneration();
        }

        synchronized (this.coordinateCellMap) {
            for ( Cell cell : this.coordinateCellMap.values() ) {
                cell.transitionToNextGeneration();
            }
        }
    }
}
