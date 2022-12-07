package agh.ics.oop;

public class Vector2d {
    public int x;
    public int y;
    public Vector2d(int x, int y){
        if(x == -0){
            x=0;
        }
        if(y == -0){
            y=0;
        }
        this.x = x;
        this.y = y;
    }
    public String toString(){
        String a = String.valueOf(this.x);
        String b = String.valueOf(this.y);
        String result = "(" + a + "," + b + ")";
        return result;
    }
    public boolean precedes(Vector2d other){
        if(this.x <= other.x && this.y <= other.y){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean follows(Vector2d other){
        if(this.x >= other.x && this.y >= other.y){
            return true;
        }
        else{
            return false;
        }
    }
    public Vector2d add(Vector2d other){
        int x_r = this.x + other.x;
        int y_r = this.y + other.y;
        Vector2d result= new Vector2d(x_r, y_r);
        return result;
    }
    public Vector2d subtract(Vector2d other){
        int x_r = this.x - other.x;
        int y_r = this.y - other.y;
        Vector2d result= new Vector2d(x_r, y_r);
        return result;
    }
    public Vector2d upperRight(Vector2d other){
        int x_r = other.x;
        int y_r = other.y;
        if(this.x > other.x){
            x_r=this.x;
        }
        if(this.y > other.y){
            y_r=this.y;
        }

        Vector2d result= new Vector2d(x_r, y_r);
        return result;
    }
    public Vector2d lowerLeft(Vector2d other){
        int x_r = other.x;
        int y_r = other.y;
        if(this.x < other.x){
            x_r=this.x;
        }
        if(this.y < other.y){
            y_r=this.y;
        }

        Vector2d result= new Vector2d(x_r, y_r);
        return result;
    }
    public Vector2d opposite(){

        int x_r=(-1)*this.x;
        int y_r=(-1)*this.y;
        if(x_r == -0){
            x_r=0;
        }
        if(y_r == -0){
            y_r=0;
        }
        Vector2d result= new Vector2d(x_r, y_r);
        return result;
    }
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        if(that.x == this.x && that.y == this.y){
            return true;
        }
        return false;
    }
    public int hashCode(){
        int result = 7;
        Integer x1= Integer.valueOf(this.x);
        Integer y1= Integer.valueOf(this.y);
        result= 31 * result + x1.hashCode();
        result = 31 * result + y1.hashCode();
        return result;

    }
}
