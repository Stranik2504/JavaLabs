public class Circle implements Comparable<Circle> {
    private final int _radius;
    
    public Circle(int radius) { _radius = radius; }
    
    public int get_radius() { return _radius; }

    @Override
    public int compareTo(Circle o) {
        if (o.get_radius() > _radius)
            return -1;
        
        if (o.get_radius() == _radius)
            return 0;
        
        return 1;
    }
    
    @Override
    public String toString() {
        return "Circle(radius: " + _radius + ")";
    }
}
