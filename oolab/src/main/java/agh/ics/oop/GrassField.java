package agh.ics.oop;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.lang.Math;
import java.util.Collections;
import java.util.*;

import static java.lang.System.out;

public class GrassField extends AbstractWorldMap{
    private int n;
    private HashMap<Vector2d, Grass> grasses;
    //private MapBoundary boundary;
  //  private ArrayList<IPositionChangeObserver> observers;

    public GrassField(int n){
        boundary=new MapBoundary();
     //   observers= new ArrayList<IPositionChangeObserver>();
      //  boundary
        this.n=n;
        grasses=new HashMap<Vector2d, Grass>();
        animals=new HashMap<Vector2d, Animal>();
        int k=0;
        while(k!=n){
            Random rand= new Random();
            double l= Math.floor(Math.sqrt(n*10));
            int a = (int)l;
            int randA=rand.nextInt(a);
            int randB=rand.nextInt(a);
            Vector2d newVector= new Vector2d(randA, randB);
            if(grasses.get(newVector)== null){
                Grass newGrass= new Grass(newVector);
                newGrass.objectPriority=0;
               // System.out.println("to to: ");
                //System.out.println(newGrass.getObservers());
                newGrass.addObserver(boundary);
                //out.println("test123");
                grasses.put(newVector, newGrass);
                boundary.objectsX.add(newGrass);
                boundary.objectsY.add(newGrass);
                k++;
            }
            Grass testGrass= new Grass(new Vector2d(11,2));
            testGrass.objectPriority=0;
            grasses.put(newVector, testGrass);
            boundary.objectsX.add(testGrass);
            boundary.objectsY.add(testGrass);

        }
        //System.out.println(grasses.get(0));
    }
    public boolean canMoveTo(Vector2d position){
        if(position.x<0  || position.y<0 ){
            return false;
        }
        if(animals.get(position) != null){
            return false;
        }
        return true;
    }

    public boolean isOccupied(Vector2d position){
        if(animals.get(position)!= null || grasses.get(position) != null){
            return true;
        }
        return false;
    }
    public Object objectAt(Vector2d position){
        if(animals.get(position)!= null){
            return animals.get(position);
        }
        return grasses.get(position);
    }
    public Vector2d findUpperRight(){
        int maxX=0;
        int maxY=0;
        Iterator<Vector2d> itrA=animals.keySet().iterator();
        while(itrA.hasNext()){
            Vector2d k=itrA.next();
            maxX=Math.max(maxX, k.x);
            maxY=Math.max(maxY, k.y);
        }
        Iterator<Vector2d> itrB=grasses.keySet().iterator();
        while(itrB.hasNext()){
            Vector2d k=itrB.next();
            maxX=Math.max(maxX, k.x);
            maxY=Math.max(maxY, k.y);
        }
        return new Vector2d(maxX, maxY);
    }

}
