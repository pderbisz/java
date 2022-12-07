package agh.ics.oop;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;
public class MapBoundary implements IPositionChangeObserver {

    Comparator<AbstractObject> comparatorX=Comparator
            .comparing(AbstractObject :: getPosX)
            .thenComparing(AbstractObject :: getPosY)
            .thenComparing(AbstractObject :: getObjectPriority);
    Comparator<AbstractObject> comparatorY=Comparator
            .comparing(AbstractObject :: getPosY)
            .thenComparing(AbstractObject :: getPosX)
            .thenComparing(AbstractObject :: getObjectPriority);
           // comparator = comparator.thenComparing()
    TreeSet<AbstractObject> objectsX = new TreeSet<AbstractObject>(comparatorX);
    TreeSet<AbstractObject> objectsY = new TreeSet<AbstractObject>(comparatorY);
    //private TreeSet<Grass> grassX = new TreeSet<>(Comparator.comparing(Grass :: getPosX));
    //private TreeSet<Grass> grassY = new TreeSet<>(Comparator.comparing(Grass :: getPosY));
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        int oldX=oldPosition.x;
        int oldY=oldPosition.y;
        int newX=newPosition.x;
        int newY=newPosition.y;
        for(AbstractObject object: objectsX){
            if(object.objectPriority==1){
                if(object.getPosX()==oldX &&object.getPosY()==oldY){
                    objectsX.remove(object);
                    objectsY.remove(object);
                    object.setPosX(newX);
                    object.setPosY(newY);
                    objectsY.add(object);
                    objectsX.add(object);
                }
            }
        }
        return;
    }
    public Vector2d findUpRight(){
        int x=objectsX.last().getPosX();
        int y=objectsY.last().getPosY();
        return new Vector2d(x,y);
    }
}
