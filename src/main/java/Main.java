import components.World;

public class Main {

    public static void main(String[] args) throws Exception {
        final int NUMBER_OF_TICKS = 10;
        int[] dimensionsArray = new int[] {10, 10};
        World world = new World(dimensionsArray);
        for ( int i = 1; i <= NUMBER_OF_TICKS; i++ ) {
            world.tick();
        }
    }
}