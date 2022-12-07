package agh.ics.oop;
import java.util.ArrayList;
public class SimulationEngine implements IEngine{
    private MoveDirection[] moves;
    private Vector2d[] pos;
    public ArrayList<Animal> animals;
    public IWorldMap map;
    private int n;
    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] pos ){
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
    }
    public void run(){
        System.out.println(map);
        System.out.println(moves.length);
        int i=0;
        while(i<moves.length){
                for(int j=0; j<n; j++){
                    animals.get(j).move(moves[i]);
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