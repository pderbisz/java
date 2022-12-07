package agh.ics.oop;

import static java.lang.System.out;
import java.util.*;
public class Animal extends AbstractObject {
     private  MapDirection currDir;
     private  Vector2d pos;
     public AbstractWorldMap map;
    private ArrayList<IPositionChangeObserver> observers;
    final public int objectPriority;
    public Animal(){
        currDir = MapDirection.NORTH;
        pos = new Vector2d(2,2);
        map = new RectangularMap(4, 4);
        observers = new ArrayList<IPositionChangeObserver>();
        objectPriority=1;
    }
    public Animal(AbstractWorldMap map){
        currDir = MapDirection.NORTH;
        pos = new Vector2d(2,2);
        this.map=map;
        observers = new ArrayList<IPositionChangeObserver>();
        objectPriority=1;
        //map.place(this);

    }
    public Animal(AbstractWorldMap map, Vector2d initialPosition){
        currDir = MapDirection.NORTH;
        pos = initialPosition;
        this.map=map;
        observers = new ArrayList<IPositionChangeObserver>();
        objectPriority=1;
       // map.place(this);
    }
    public MapDirection getDir(){
        return currDir;
    }
    public Vector2d getPos(){
        return pos;
    }
    public int getPosX(){
        return pos.x;
    }
    public int getPosY(){ return pos.y; }
    public int getObjectPriority(){ return objectPriority;}
    public String toString(){
       // Integer x1=pos.x;
        //Integer y1=pos.y;
       // String xS=Integer.toString(pos.x);
       // String yS=Integer.toString(pos.y);
     //   String dS=currDir.toString();
     //   String result= "(" + xS + "," + yS + ") "  + dS;
        String result = "";
        switch(currDir){
            case NORTH:
                result="N";
                break;
            case SOUTH:
                result="S";
                break;
            case WEST:
                result="W";
                break;
            case EAST:
                result="E";
                break;
            default:
                result="???";
                break;
        }
        return result;
    }
    boolean isAt(Vector2d position){

        return pos.equals(position);
    }

    public void move(MoveDirection direction){
        Vector2d goal= new Vector2d(pos.x, pos.y);

        switch(direction){
            case RIGHT:
               currDir=currDir.next();
                //out.println("testdir");
                break;
            case LEFT:
                currDir= currDir.previous();
                break;
            case FORWARD:
                if(currDir == MapDirection.NORTH){
                   // out.println("test1111");
                    goal.y+=1;
                    //out.println(goal);
                }
                if(currDir == MapDirection.SOUTH){

                    goal.y-=1;
                }
                if(currDir == MapDirection.EAST){
                    goal.x+=1;
                }
                if(currDir == MapDirection.WEST){
                   goal.x-=1;
                }
                break;
            case BACKWARD:
                if(currDir == MapDirection.NORTH){
                    goal.y-=1;
                }
                if(currDir == MapDirection.SOUTH){
                    goal.y+=1;
                }
                if(currDir == MapDirection.EAST){
                    goal.x-=1;
                }
                if(currDir == MapDirection.WEST){
                    goal.x+=1;
                }
                break;
            default:
               // out.println("zła wartość");
                break;
        }
        if(map.canMoveTo(goal)){
            //out.println("ccc");
            //out.println(goal);
            Vector2d temp=new Vector2d(pos.x, pos.y);
            pos=goal;
            positionChanged(temp, pos);
        }
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
       // out.println("bbb");
        for(int i=0; i<observers.size(); i++){
           // out.println("aaa");
            observers.get(i).positionChanged(oldPosition, newPosition);
        }
    }
    void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }
}
