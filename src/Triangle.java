public class Triangle extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;
    
    public Triangle() {
        super();
    }
    
    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        super();
        
        if (side1 >= side2 + side3)
            throw new IllegalTriangleException();

        if (side2 >= side1 + side3)
            throw new IllegalTriangleException();

        if (side3 >= side1 + side2)
            throw new IllegalTriangleException();
        
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    public double getArea() {
        var s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
    public double getPerimeter() { return side1 + side2 + side3; }
    
    public String toString() {
        return "Треугольник: сторона1 = " + side1 + " сторона2 = " + side2 +
                " сторона3 = " + side3;
    }
    
    public void setSide1(double side1) { this.side1 = side1; }
    public double getSide1() { return this.side1; }

    public void setSide2(double side2) { this.side2 = side2; }
    public double getSide2() { return this.side2; }

    public void setSide3(double side3) { this.side3 = side3; }
    public double getSide3() { return this.side3; }
}
