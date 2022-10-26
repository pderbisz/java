package agh.ics.oop;

import static java.lang.System.out;

public class OptionsParser {
    static public MoveDirection[] parse(String[] s){
        for(int i=0; i<s.length; i++){
            out.println(s[i]);
        }
        int n=s.length;
        int size=0;
        for(int i=0; i<n; i++){
            if(s[i].equals("f") || s[i].equals("forward") || s[i].equals("b") || s[i].equals("backward") || s[i].equals("r") || s[i].equals("right") || s[i].equals("l") || s[i].equals("left")){
                size++;

            }


        }
        System.out.println(size);
        MoveDirection[] result = new MoveDirection[size];
        int currIdx=0;
        for(int i=0; i<n; i++){
            if(s[i].equals("f") || s[i].equals("forward")){
                result[currIdx]=MoveDirection.FORWARD;
                currIdx++;
            }
            else if(s[i].equals("b")  || s[i].equals("backward")){
                result[currIdx]=MoveDirection.BACKWARD;
                currIdx++;
            }
            else if(s[i].equals("r") || s[i].equals("right")){
                result[currIdx]=MoveDirection.RIGHT;
                currIdx++;
            }
            else if(s[i].equals("l") || s[i].equals("left")){
                result[currIdx]=MoveDirection.LEFT;
                currIdx++;
            }
        }
        System.out.println("cos");
        return result;

    }
}
