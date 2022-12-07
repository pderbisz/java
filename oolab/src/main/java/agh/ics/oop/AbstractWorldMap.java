package agh.ics.oop;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    MapBoundary boundary;
    public abstract Vector2d findUpperRight();
    public boolean isOccupied(Vector2d position){
        if(animals.get(position)!= null){
            return true;
        }
        return false;
    }
    public Object objectAt(Vector2d position){
        return animals.get(position);
    }
    abstract public boolean canMoveTo(Vector2d position);
    public boolean place(Animal animal){

        if(canMoveTo(animal.getPos())){
           // System.out.println("testabc");
            animals.put(animal.getPos(), animal);
            animal.addObserver(this);
            animal.addObserver(boundary);
            boundary.objectsX.add(animal);
            boundary.objectsY.add(animal);
            return true;
        }
        else{
            throw new IllegalArgumentException("cannot move to "+animal.getPos());
        }

    }
    public String toString(){
        MapVisualizer mV= new MapVisualizer(this);
        Vector2d lowerL= new Vector2d(0, 0);
        Vector2d upperR=boundary.findUpRight();
        return mV.draw(lowerL, upperR);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal t=animals.remove(oldPosition);
        animals.put(newPosition, t);
    }
}
