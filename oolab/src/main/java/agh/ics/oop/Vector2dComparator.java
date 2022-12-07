package agh.ics.oop;
import java.util.Comparator;
public class Vector2dComparator implements Comparator<Vector2d> {
    @Override
    public int compare(Vector2d v1, Vector2d v2) {
        return Double.compare(v1.getSuitability(), v2.getSuitability());
    }
}
