package agh.ics.oop;
import java.util.ArrayList;
import java.util.*;

class RectangularMap extends AbstractWorldMap {
    private int h;
    private int w;
    public RectangularMap(int width, int height){
        h=height;
        w=width;
        animals= new HashMap<Vector2d, Animal>();
    }
    public boolean canMoveTo(Vector2d position){
        if(position.x<0 || position.x>w || position.y<0 || position.y>h){
            return false;
        }

        if(animals.get(position)== null){
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
