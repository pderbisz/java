package agh.ics.oop;

import java.util.ArrayList;

public class Grass extends AbstractObject {

    public int objectPriority=0;
    public int getObjectPriority(){ return objectPriority;}
    private ArrayList<IPositionChangeObserver> observers;
    private Vector2d pos;
    public Grass(Vector2d vector){
        pos=vector;
        observers=new ArrayList<IPositionChangeObserver>();
        IPositionChangeObserver obs= new MapBoundary();
        observers.add(obs);
    }
    public Vector2d getPos(){
        return pos;
    }
    public int getPosX(){
        return pos.x;
    }
    public int getPosY(){
        return pos.y;
    }
    public String toString(){
        return "*";
    }
    void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }
}
