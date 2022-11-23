package agh.ics.oop;

import static java.lang.System.out;
import java.util.*;
public class Animal {
     private  MapDirection currDir ;
     private  Vector2d currPos;
     public AbstractWorldMap map;
     private ArrayList<IPositionChangeObserver> observers;
    public Animal(){
        currDir = MapDirection.NORTH;
        currPos = new Vector2d(2,2);
        map = new RectangularMap(4, 4);
        observers = new ArrayList<IPositionChangeObserver>();
    }
    public Animal(AbstractWorldMap map){
        currDir = MapDirection.NORTH;
        currPos = new Vector2d(2,2);
        this.map=map;
        observers = new ArrayList<IPositionChangeObserver>();
        //map.place(this);

    }
    public Animal(AbstractWorldMap map, Vector2d initialPosition){
        currDir = MapDirection.NORTH;
        currPos = initialPosition;
        this.map=map;
        observers = new ArrayList<IPositionChangeObserver>();
       // map.place(this);
    }
    public MapDirection getDir(){
        return currDir;
    }
    public Vector2d getPos(){
        return currPos;
    }
    public String toString(){
       // Integer x1=currPos.x;
        //Integer y1=currPos.y;
       // String xS=Integer.toString(currPos.x);
       // String yS=Integer.toString(currPos.y);
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

        return currPos.equals(position);
    }
    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(int i=0; i<observers.size(); i++){
            observers.get(i).positionChanged(oldPosition, newPosition);
        }
    }
    public void move(MoveDirection direction){
        Vector2d goal= new Vector2d(currPos.x, currPos.y);

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
            //out.println(goal);
            Vector2d temp=new Vector2d(currPos.x, currPos.y);
            currPos=goal;
            positionChanged(temp, currPos);
        }
    }
    void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

}
