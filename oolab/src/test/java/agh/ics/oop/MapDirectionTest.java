package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {

    @Test void nextNorth(){
        MapDirection d= MapDirection.NORTH;
        assertEquals(MapDirection.EAST, d.next());

    }
    @Test void nextSouth(){
        MapDirection d= MapDirection.SOUTH;
        assertEquals(MapDirection.WEST, d.next());

    }
    @Test void nextWest(){
        MapDirection d= MapDirection.WEST;
        assertEquals(MapDirection.NORTH, d.next());

    }
    @Test void nextEast(){
        MapDirection d= MapDirection.EAST;
        assertEquals(MapDirection.SOUTH, d.next());

    }
    @Test void previousNorth(){
        MapDirection d= MapDirection.NORTH;
        assertEquals(MapDirection.WEST, d.previous());

    }
    @Test void previousSouth(){
        MapDirection d= MapDirection.SOUTH;
        assertEquals(MapDirection.EAST, d.previous());

    }
    @Test void previousWest(){
        MapDirection d= MapDirection.WEST;
        assertEquals(MapDirection.SOUTH, d.previous());

    }
    @Test void previousEast(){
        MapDirection d= MapDirection.EAST;
        assertEquals(MapDirection.NORTH, d.previous());

    }
}
