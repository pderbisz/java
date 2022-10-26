package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    Animal cow = new Animal();

    @Test
    void orientationTest1(){
        MapDirection directionTest= cow.getDir();
        cow.move(MoveDirection.LEFT);
        cow.move(MoveDirection.RIGHT);
        assertEquals(directionTest,cow.getDir());
    }
    @Test
    void orientationTest2(){
        MapDirection directionTest= cow.getDir();
        cow.move(MoveDirection.LEFT);
        cow.move(MoveDirection.LEFT);
        cow.move(MoveDirection.LEFT);
        cow.move(MoveDirection.LEFT);

        assertEquals(directionTest,cow.getDir());
    }
    @Test
    void orientationTest3(){
        MapDirection directionTest= cow.getDir();
        for(int i=0; i<3; i++){
            cow.move(MoveDirection.LEFT);
            directionTest=directionTest.previous();
        }
        assertEquals(directionTest,cow.getDir());
    }
    @Test
    void orientationTest4(){
        MapDirection directionTest= cow.getDir();
        for(int i=0; i<3; i++){
            cow.move(MoveDirection.RIGHT);
            cow.move(MoveDirection.FORWARD);
            directionTest=directionTest.next();
        }
        assertEquals(directionTest,cow.getDir());
    }
    @Test
    void orientationTest5(){
        MapDirection directionTest= cow.getDir();
        for(int i=0; i<3; i++){
            cow.move(MoveDirection.LEFT);
            directionTest=directionTest.next();
        }
        assertNotEquals(directionTest,cow.getDir());
    }
    Vector2d posTest= new Vector2d(2,3);
    @Test
    void positionTest1(){

        cow.move(MoveDirection.FORWARD);
        assertTrue(cow.isAt(posTest));
    }
    @Test
    void positionTest2(){

        //Vector2d posTest= new Vector2d(1,1);
        posTest.x=1;
        posTest.y=1;
        cow.move(MoveDirection.BACKWARD);
        cow.move(MoveDirection.RIGHT);
        cow.move(MoveDirection.BACKWARD);
        assertTrue(cow.isAt(posTest));
    }
    @Test
    void boundaryTest1(){
        //Vector2d posTest= new Vector2d(2,1);
        posTest.x=4;
        posTest.y=4;
        for(int i=0; i<10; i++){
            cow.move(MoveDirection.FORWARD);
        }
        cow.move(MoveDirection.RIGHT);
        for(int i=0; i<10; i++){
            cow.move(MoveDirection.FORWARD);
        }
        assertTrue(cow.isAt(posTest));
    }
    @Test
    void boundaryTest2(){
        //Vector2d posTest= new Vector2d(2,1);
        posTest.x=0;
        posTest.y=0;
        for(int i=0; i<10; i++){
            cow.move(MoveDirection.BACKWARD);
        }
        cow.move(MoveDirection.RIGHT);
        for(int i=0; i<10; i++){
            cow.move(MoveDirection.BACKWARD);
        }
        assertTrue(cow.isAt(posTest));
    }
    @Test
    void inputTest1(){
        posTest.x=3;
        posTest.y=4;
        String[] s = {"test", "f", "a", "forward", "", "r", "forward"};
        MoveDirection[] steer= OptionsParser.parse(s);
        for(int i=0; i<steer.length; i++){
            cow.move(steer[i]);
        }
        assertTrue(cow.isAt(posTest));
    }

}