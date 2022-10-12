package agh.ics.oop;
import static java.lang.System.out;
public class World {
    public static void main(String[] args){
        out.println("system wystartował");
        Direction[] dirs=convert(moves);
        run(dirs);
        out.println("system zakończył działanie");
    }
    static void run(Direction[] dirs){
        int size=dirs.length;
       // out.println("Zwierzak ruszył się do przodu");
        out.println("Start");
        for(int i=0; i<size; i++){
           /* out.print(moves[i]);
            if (i<size-1){
                out.print(", ");
            } */
            switch(dirs[i]){
                case f:
                    out.println("Zwierzak idzie do przodu");
                    break;
                case b:
                    out.println("Zwierzak idzie do tyłu");
                    break;
                case r:
                    out.println("Zwierzak skręca w prawo");
                    break;
                case l:
                    out.println("Zwierzak skręca w lewo");
                    break;

            }
        }
        out.println("Stop");
    }
    static Direction[] convert(String[] moves){
        int size=moves.length;
        Direction[] dirs = new Direction[size];
        for(int i=0; i<size; i++){
            switch(moves[i]){
                case "f":
                    dirs[i]=Direction.f;
                    break;
                case "b":
                    dirs[i]=Direction.b;
                    break;
                case "r":
                    dirs[i]=Direction.r;
                    break;
                case "l":
                    dirs[i]=Direction.l;
                    break;
            }
        }
        return dirs;
    }
    static String[] moves = {"f", "f", "r", "l"};
   // static Direction[] dirs = {Direction.f, Direction.f, Direction.r, Direction.l};

}
