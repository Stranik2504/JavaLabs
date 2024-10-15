package prognew;

public class TestMaxGeometricObject {
    public static void main(String[] args) throws IllegalTriangleException {
        // Task 3
        var c1 = new Circle(1);
        var c2 = new Circle(5);

        if (GeometricObject.max(c1, c2).equals(c2))
            System.out.println("Circle max is correct");
        else
            System.out.println("Circle max is incorrect");

        var r1 = new Rectangle(1, 1);
        var r2 = new Rectangle(2, 1);

        if (GeometricObject.max(r1, r2).equals(r2))
            System.out.println("Rectangle max is correct");
        else
            System.out.println("Rectangle max is incorrect");

        var cmpC1 = new ComparableCircle(1);
        var cmpC2 = new ComparableCircle(5);

        if (cmpC1.compareTo(cmpC2) < 0)
            System.out.println("ComparableCircle max is correct");
        else
            System.out.println("ComparableCircle max is incorrect");
    }
}
