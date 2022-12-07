package agh.ics.oop;

public class Grass {
    private Vector2d pos;
    public Grass(Vector2d vector){
        pos=vector;
    }
    public Vector2d getPos(){
        return pos;
    }
    public String toString(){
        return "*";
    }
}
