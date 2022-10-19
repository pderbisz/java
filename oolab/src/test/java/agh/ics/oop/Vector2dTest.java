package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class Vector2dTest {
    @Test void equalsVectorFalse(){
        Vector2d a = new Vector2d(1, 1);
        Vector2d b = new Vector2d(1, -1);
        assertTrue(a.equals(b) == false);
    }
    @Test void equalsVectorTrue(){
        Vector2d a = new Vector2d(1, 1);
        Vector2d b = new Vector2d(1, 1);
        assertTrue(a.equals(b) == true);
    }
    @Test void toStringTest1(){
        Vector2d a = new Vector2d(1,1);
        String s = "(1,1)";
        assertTrue(s.equals(a.toString()));
    }
    @Test void precedesTestIdentical(){
        Vector2d a = new Vector2d(1,1);
        //Vector2d b = new Vector2d(1,1);
        assertTrue(a.precedes(a));
    }
    @Test void precedesTestOther(){
        Vector2d a = new Vector2d(1,1);
        Vector2d b = new Vector2d(2,1);
        assertTrue(a.precedes(b));
    }
    @Test void followsTestOther(){
        Vector2d a = new Vector2d(1,1);
        Vector2d b = new Vector2d(2,1);
        assertFalse(a.follows(b));
    }
    @Test void upperRightTest1(){
        Vector2d a = new Vector2d(1,3);
        Vector2d b = new Vector2d(2,1);
        Vector2d c = a.upperRight(b);
        Vector2d test = new Vector2d(2, 3);
        assertEquals(c, test);
    }
    @Test void lowerLeftTest1(){
        Vector2d a = new Vector2d(1,3);
        Vector2d b = new Vector2d(2,1);
        Vector2d c = a.lowerLeft(b);
        Vector2d test = new Vector2d(1, 1);
        assertEquals(c, test);
    }
    @Test void lowerLeftTest2(){
        Vector2d a = new Vector2d(-10,-5);
        Vector2d b = new Vector2d(-20,-3);
        Vector2d c = a.lowerLeft(b);
        Vector2d test = new Vector2d(-20, -5);
        assertEquals(c, test);
    }
    @Test void addVectorTest1(){
        Vector2d a = new Vector2d(1,3);
        Vector2d b = new Vector2d(2,-1);
        Vector2d c = a.add(b);
        Vector2d test = new Vector2d(3, 2);
        assertEquals(c, test);
    }
    @Test void addVectorTest2(){
        Vector2d a = new Vector2d(-10,-10);
        Vector2d b = new Vector2d(10,10);
        Vector2d c = a.add(b);
        Vector2d test = new Vector2d(0, 0);
        assertEquals(c, test);
    }
    @Test void subtractVectorTest1(){
        Vector2d a = new Vector2d(1,3);
        Vector2d b = new Vector2d(2,-1);
        Vector2d c = a.subtract(b);
        Vector2d test = new Vector2d(-1, 4);
        assertEquals(c, test);
    }
    @Test void subtractVectorTest2(){
        Vector2d a = new Vector2d(0,0);
        Vector2d b = new Vector2d(2,-1);
        Vector2d c = a.subtract(b);
        Vector2d test = new Vector2d(-1, 4);
        assertFalse(c.equals(test));
    }
    @Test void oppositeTest1(){
        Vector2d a = new Vector2d(-1,3);
        Vector2d b= a.opposite();
        Vector2d test = new Vector2d(1, -3);
        assertEquals(b, test);
    }
    @Test void oppositeTestZero(){
        Vector2d a = new Vector2d(0,0);
        Vector2d b= a.opposite();
        Vector2d test = new Vector2d(0, 0);
        assertEquals(b, test);
    }
}
