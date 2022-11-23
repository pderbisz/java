package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SimulationEngineTest {

    @Test
    void collisionTest1(){
        String[] strMoves={"f", "l", "f", "l", "r", "l", "f", "l", "f", "l", "f"};
        MoveDirection[] directions = new OptionsParser().parse(strMoves);
        AbstractWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertNotEquals(engine.animals.get(0).getPos(), engine.animals.get(1).getPos());

    }
    @Test
    void defaultTest(){
        Vector2d result1 = new Vector2d(2, 0);
        Vector2d result2 = new Vector2d(3, 5);
        String[] strMoves={"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(strMoves);
        AbstractWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertEquals(engine.animals.get(0).getPos(), result1);
        assertEquals(engine.animals.get(1).getPos(), result2);

    }
    @Test
    void spawnTest1(){
        Vector2d testVector= new Vector2d(2, 2);
        String[] strMoves={};
        MoveDirection[] directions = new OptionsParser().parse(strMoves);
        AbstractWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,2) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertNotEquals(engine.map.objectAt(testVector), engine.animals.get(1).getPos());

    }
}
