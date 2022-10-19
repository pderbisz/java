package agh.ics.oop;
import static java.lang.System.out;
public class World {
    public static void main(String[] args){
        out.println("system wystartował");
       // Direction[] dirs=convert(args);
       // run(dirs);
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection d = MapDirection.NORTH;
        Vector2d test = d.toUnitVector();
        d=d.previous();
        System.out.println(d);
        out.println("system zakończył działanie");
    }
    static void run(Direction[] dirs){
        int size=dirs.length;
        out.println("Start");
        for(int i=0; i<size; i++){
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
        int m=moves.length;
      // out.println(moves.length);
        int size=0;
        for (int i=0; i<m; i++){
            if(moves[i].equals("f") || (moves[i].equals("b")|| (moves[i].equals("r") ||(moves[i].equals("l"))))){
                size++;
            }
        }
        Direction[] dirs = new Direction[size];
        int j=0;
        for(int i=0; i<m; i++){
            switch(moves[i]){
                case "f":
                    dirs[j]=Direction.f;
                    j++;
                    break;
                case "b":
                    dirs[j]=Direction.b;
                    j++;
                    break;
                case "r":
                    dirs[j]=Direction.r;
                    j++;
                    break;
                case "l":
                    dirs[j]=Direction.l;
                    j++;
                    break;
                default:
                    break;
            }
        }
        return dirs;
    }
    static String[] moves = {"f", "f", "r", "l"};
   // static Direction[] dirs = {Direction.f, Direction.f, Direction.r, Direction.l};

}
