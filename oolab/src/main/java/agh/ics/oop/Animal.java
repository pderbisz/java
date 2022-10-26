package agh.ics.oop;

import static java.lang.System.out;

public class Animal {
     private  MapDirection currDir ;
     private  Vector2d currPos;
    public Animal(){
        currDir = MapDirection.NORTH;
        currPos = new Vector2d(2,2);
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
        String xS=Integer.toString(currPos.x);
        String yS=Integer.toString(currPos.y);
        String dS=currDir.toString();
        String result=xS + " " + yS + " " + dS;

        return result;
    }
    boolean isAt(Vector2d position){

        return currPos.equals(position);
    }
    public void move(MoveDirection direction){

        switch(direction){
            case RIGHT:
               currDir=currDir.next();
                //out.println("testdir");
                break;
            case LEFT:
                currDir= currDir.previous();
                break;
            case FORWARD:
                if(currDir == MapDirection.NORTH && currPos.y<4){
                    currPos.y+=1;
                    //out.println("test");
                   // out.println(this.currPos.x);
                }
                if(currDir == MapDirection.SOUTH && currPos.y>0){
                    currPos.y-=1;
                }
                if(currDir == MapDirection.EAST && currPos.x<4){
                    currPos.x+=1;
                }
                if(currDir == MapDirection.WEST && currPos.x>0){
                    currPos.x-=1;
                }
                break;
            case BACKWARD:
                if(currDir == MapDirection.NORTH && currPos.y>0){
                    currPos.y-=1;
                }
                if(currDir == MapDirection.SOUTH && currPos.y<4){
                    currPos.y+=1;
                }
                if(currDir == MapDirection.EAST && currPos.x>0){
                    currPos.x-=1;
                }
                if(currDir == MapDirection.WEST && currPos.x<4){
                    currPos.x+=1;
                }
                break;
            default:
                out.println("zła wartość");
                break;
        }
    }
}
