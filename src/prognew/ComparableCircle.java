package prognew;

public class ComparableCircle extends Circle implements Comparable, Colorable {
    public ComparableCircle() {
        super();
    }
    
    public ComparableCircle(double radius) {
        super(radius);
    }
    
    @Override
    public int compareTo(Object obj) {
        if (!(obj instanceof ComparableCircle cmpCircle))
            return 0;

        if (cmpCircle.getArea() > getArea())
            return -1;

        return cmpCircle.getArea() == getArea() ? 0 : 1;
    }
}
