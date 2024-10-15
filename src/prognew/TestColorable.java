package prognew;

import java.util.List;

public class TestColorable {
    public static void main(String[] args) throws IllegalTriangleException {
        // Task 4
         // List<GeometricObject> objs = List.of(new Triangle(), new Square(), new Rectangle(), new ComparableCircle(), new Circle());
        List<GeometricObject> objs = List.of(
                new Triangle(3, 4, 5), 
                new Square(10), 
                new Rectangle(3, 4), 
                new ComparableCircle(5), 
                new Circle(1)
        );
        
        for (var obj : objs) {
            if (obj instanceof Colorable colorable) {
                System.out.println("Площадь равна: " + obj.getArea());
                colorable.howToColor();
            }
        }
    }
}
