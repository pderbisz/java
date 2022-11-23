package agh.ics.oop;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
public class GrassField extends AbstractWorldMap{
    private int n;
    private ArrayList<Grass> grasses;
    public GrassField(int n){
        this.n=n;
        grasses=new ArrayList<Grass>();
        animals=new ArrayList<Animal>();
        int k=0;
        while(k!=n){
            Random rand= new Random();
            double l= Math.floor(Math.sqrt(n*10));
            int a = (int)l;
            int randA=rand.nextInt(a);
            int randB=rand.nextInt(a);
            Vector2d newVector= new Vector2d(randA, randB);
            boolean free = true;

            for(int i=0; i<grasses.size(); i++){
                if(newVector.equals(grasses.get(i).getPos())){
                    free = false;
                }
            }

            if(free){
                Grass newGrass= new Grass(newVector);
                grasses.add(newGrass);
                k+=1;
            }
        }
        System.out.println(grasses.get(0));
    }
    public boolean canMoveTo(Vector2d position){
        if(position.x<0  || position.y<0 ){
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
        for(int i=0; i<animals.size(); i++){
            if(position.equals(animals.get(i).getPos())){
                return true;
            }
        }
        for(int i=0; i<grasses.size(); i++){
            if(position.equals(grasses.get(i).getPos())){
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
        for(int i=0; i<grasses.size(); i++){
            if(position.equals(grasses.get(i).getPos())){
                return grasses.get(i);
            }
        }
        return null;
    }
    Vector2d findUpperRight(){
        int maxX=0;
        int maxY=0;
        for(int i=0; i<animals.size(); i++){
            if(animals.get(i).getPos().x>maxX){
                maxX=animals.get(i).getPos().x;
            }
            if(animals.get(i).getPos().y>maxY){
                maxY=animals.get(i).getPos().y;
            }
        }
        for(int i=0; i<grasses.size(); i++){
            if(grasses.get(i).getPos().x>maxX){
                maxX=grasses.get(i).getPos().x;
            }
            if(grasses.get(i).getPos().y>maxY){
                maxY=grasses.get(i).getPos().y;
            }
        }
        return new Vector2d(maxX, maxY);
    }
}
