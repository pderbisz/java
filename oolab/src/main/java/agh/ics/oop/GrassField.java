package agh.ics.oop;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.lang.Math;
import java.util.Collections;
import java.util.*;
public class GrassField extends AbstractWorldMap{
    private int n;
    private HashMap<Vector2d, Grass> grasses;
    public GrassField(int n){
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
                grasses.put(newVector, newGrass);
                k+=1;
            }

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
    public boolean place(Animal animal){
        if(canMoveTo(animal.getPos())){
            animals.put(animal.getPos(), animal);
            return true;
        }
        return false;
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
    Vector2d findUpperRight(){
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
