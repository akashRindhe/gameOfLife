package components;

import java.util.ArrayList;
import java.util.List;

public class Coordinate {
    final int x;
    final int y;
    private static final int SIZE = 2;
    private List<Coordinate> neighbouringCoordinates;

    Coordinate( int[] dimensions ) throws Exception {
        if ( dimensions.length != SIZE) {
            throw new Exception( "Incorrect dimensions of coordinate : expected - " + SIZE + " got - " + dimensions.length  );
        }
        this.x = dimensions[0];
        this.y = dimensions[1];
    }

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        int hashcode = this.y;
        hashcode = hashcode*33 + this.x;
        return hashcode;
    }

    @Override
    public boolean equals(Object o) {
        if ( o instanceof Coordinate ) {
            Coordinate coordinate = (Coordinate)o;
            return this.x == coordinate.x && this.y == coordinate.y;
        }
        return false;
    }

    List<Coordinate> getNeighbouringCoordinates() {
        if ( neighbouringCoordinates == null ) {
            this.neighbouringCoordinates = new ArrayList<>();
            for ( int i = this.x - 1;  i <= this.x + 1; i++ ) {
                for ( int j = this.y - 1; j <= this.y + 1; j++ ) {
                    Coordinate coordinate = new Coordinate(i, j);
                    neighbouringCoordinates.add( coordinate );
                }
            }
        }
        return neighbouringCoordinates;
    }
}
