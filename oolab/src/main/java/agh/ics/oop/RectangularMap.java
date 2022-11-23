package agh.ics.oop;
import java.util.ArrayList;

class RectangularMap extends AbstractWorldMap {
    private int h;
    private int w;
    public RectangularMap(int width, int height){
        h=height;
        w=width;
        animals= new ArrayList<Animal>();
    }
    public boolean canMoveTo(Vector2d position){
        if(position.x<0 || position.x>w || position.y<0 || position.y>h){
            return false;
        }

        for(int i=0; i<animals.size(); i++){
            if(position.equals(animals.get(i).getPos())){
                return false;
            }
        }
        return true;
    }
    public boolean place(Animal animal){
            if(canMoveTo(animal.getPos())){
                animals.add(animal);
                return true;
        }
        return false;
    }
    public boolean isOccupied(Vector2d position){
        return super.isOccupied(position);
    }
    public Object objectAt(Vector2d position){
        return super.objectAt(position);
    }
    Vector2d findUpperRight(){
        return new Vector2d(w, h);
    }
}
