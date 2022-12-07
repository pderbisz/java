package agh.ics.oop;
import java.util.ArrayList;
public class SimulationEngine implements IEngine{
    private MoveDirection[] moves;
    private Vector2d[] pos;
    public ArrayList<Animal> animals;
    public AbstractWorldMap map;
    private int n;
    public SimulationEngine(MoveDirection[] moves, AbstractWorldMap map, Vector2d[] pos ){
        animals= new ArrayList<Animal>();
        this.map=map;
        this.moves=moves;
        this.pos=pos;
        n=pos.length;

        for(int i=0; i<n; i++){
            Animal t = new Animal(map, pos[i]);
            animals.add(t);
            map.place(t);
        }
     //   System.out.println(map.boundary.objectsX);
      //  System.out.println(map.boundary.objectsY);
       // System.out.println("Largest x");
     //   System.out.println(map.boundary.objectsX.last().getPos());
      //  System.out.println(map.boundary.objectsX.last());
     //   System.out.println("Largest y");
       // System.out.println(map.boundary.objectsY.last().getPos());


    }
    public void run(){
        System.out.println(map);
        System.out.println(moves.length);
        int i=0;
        while(i<moves.length){
                for(int j=0; j<n; j++){
                    animals.get(j).move(moves[i]);
                    //Animal animal=map.objectAt(pos[j]);
                   // animal.move(moves[i]);
                    System.out.println((moves[i]));
                    System.out.println(map);
                    i++;

                    if(i>=moves.length){
                        break;
                    }
                }
        }

        System.out.println(map);
    }
}
