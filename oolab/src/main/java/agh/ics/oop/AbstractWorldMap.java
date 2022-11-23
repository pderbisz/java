package agh.ics.oop;
import java.util.ArrayList;
abstract class AbstractWorldMap implements IWorldMap {
    protected ArrayList<Animal> animals = new ArrayList<>();
    abstract Vector2d findUpperRight();
    public boolean isOccupied(Vector2d position){
        for(int i=0; i<animals.size(); i++){
            if(position.equals(animals.get(i).getPos())){
                return true;
            }
        }

        return false;
    }
    public Object objectAt(Vector2d position){
        for(int i=0; i<animals.size(); i++){
            if(position.equals(animals.get(i).getPos())){
                return animals.get(i);
            }
        }
        return null;
    }
    abstract public boolean canMoveTo(Vector2d position);
    public boolean place(Animal animal){
        if(canMoveTo(animal.getPos())){
            animals.add(animal);
            return true;
        }
        return false;
    }
    public String toString(){
        MapVisualizer mV= new MapVisualizer(this);
        Vector2d lowerL= new Vector2d(0, 0);
        Vector2d upperR= findUpperRight();
        return mV.draw(lowerL, upperR);
    }

}
