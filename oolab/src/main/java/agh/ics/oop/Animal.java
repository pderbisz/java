package agh.ics.oop;

import static java.lang.System.out;

public class Animal {
     private  MapDirection currDir ;
     private  Vector2d currPos;
     public IWorldMap map;
    public Animal(){
        currDir = MapDirection.NORTH;
        currPos = new Vector2d(2,2);
        map = new RectangularMap(4, 4);
    }
    public Animal(IWorldMap map){
        currDir = MapDirection.NORTH;
        currPos = new Vector2d(2,2);
        this.map=map;
        //map.place(this);

    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        currDir = MapDirection.NORTH;
        currPos = initialPosition;
        this.map=map;
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
            currPos=goal;

        }
    }
}
