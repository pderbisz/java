package agh.ics.oop;

enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString(){
        switch(this){
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            case WEST:
                return "Zachód";
            case EAST:
                return "Wschód";
            default:
                break;
        }
        return "";
    }
    public MapDirection next(){

        switch(this){
            case NORTH:
               // System.out.println("test");
                return EAST;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            case EAST:
                return SOUTH;
            default:
                return NORTH;
        }
    }
    public MapDirection previous(){
        switch(this){
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            case EAST:
                return NORTH;
            default:
                return NORTH;
        }
    }
    public Vector2d toUnitVector(){
        int x=0;
        int y=0;
        switch(this){
            case NORTH:
                y=1;
                break;
            case SOUTH:
                y=(-1);
            case WEST:
                x=(-1);
            case EAST:
                x=1;
            default: break;
        }
        return new Vector2d(x, y);
    }
}
