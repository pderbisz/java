package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class IWorldMapTest {
    AbstractWorldMap map;
    Vector2d position= new Vector2d(5,5);
    @Test
    void ObjectAtOccupiedTestRM(){
        map= new RectangularMap(10,5);
        Animal sheep = new Animal(map, position);
        map.place(sheep);
        assertEquals(map.objectAt(position), sheep);
        assertTrue(map.isOccupied(position));
    }
    @Test
    void placeTestRM(){
        map= new RectangularMap(10,5);
        Animal sheep = new Animal(map,position);
        Animal cow = new Animal(map,position);
        map.place(sheep);
        map.place(cow);
        assertEquals(sheep, map.objectAt(position));
        assertNotEquals(cow, map.objectAt(position));
        assertTrue(map.isOccupied(position));
    }
    @Test
    void ObjectAtTestGF(){
        map= new GrassField(10);
        Animal sheep = new Animal(map, position);
        map.place(sheep);
        assertEquals(map.objectAt(position), sheep);
    }
    @Test
    void placeTestGF(){
        map= new GrassField(10);
        Animal sheep = new Animal(map,position);
        Animal cow = new Animal(map,position);
        map.place(sheep);
        map.place(cow);
        assertEquals(sheep, map.objectAt(position));
        assertNotEquals(cow, map.objectAt(position));
    }
}
