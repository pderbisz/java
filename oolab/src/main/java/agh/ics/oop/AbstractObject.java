package agh.ics.oop;

import java.util.ArrayList;

abstract class AbstractObject {

    private  Vector2d pos;
    public int objectPriority;
    public int getObjectPriority(){ return objectPriority;}
    public Vector2d getPos(){
        return pos;
    }
   // private ArrayList<IPositionChangeObserver> observers;
    public int getPosX(){
        return pos.x;
    }
    public void setPosX(int x){
        pos.x=x;
    }
    public void setPosY(int y){
        pos.y=y;
    }
    public int getPosY(){
        return pos.y;
    }
   /* public ArrayList<IPositionChangeObserver> getObservers(){
        return observers;
    }
    void addObserver(IPositionChangeObserver observer){
        getObservers().add(observer);
    }
    void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }*/
}
