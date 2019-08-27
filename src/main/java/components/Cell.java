package components;

import java.util.List;

public class Cell {
    private boolean living;
    private boolean aliveInNextGeneration;
    private final Coordinate coordinate;
    private final World world;

    public Cell(World world, Coordinate coordinate, boolean living) {
        this.world = world;
        this.living = living;
        this.coordinate = coordinate;
    }

    public Cell(World world, Coordinate coordinate) {
        this(world, coordinate, false);
    }

    public void setLiving() {
        living = true;
    }

    public void setDead() {
        living = false;
    }

    public boolean isLiving() {
        return living;
    }

    public boolean isAliveInNextGeneration() {
        return aliveInNextGeneration;
    }

    public void transitionToNextGeneration() {
        living = aliveInNextGeneration;
        aliveInNextGeneration = false;
    }

    public void calculateStateInNextGeneration() {
        List<Coordinate> neighbouringCoordinates = this.coordinate.getNeighbouringCoordinates();
        int numberOfNeighboursAlive = this.world.getLiveNeighbourCountFromList( neighbouringCoordinates );
        calculateStateInNextGeneration( numberOfNeighboursAlive);
    }

    private void calculateStateInNextGeneration( int numberOfNeighboursAlive ) {
        if ( isLiving() ) {
            aliveInNextGeneration = numberOfNeighboursAlive == 2 || numberOfNeighboursAlive == 3;
        } else {
            aliveInNextGeneration = numberOfNeighboursAlive == 3;
        }
    }
}
