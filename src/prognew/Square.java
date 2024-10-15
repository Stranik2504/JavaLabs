package prognew;

public class Square extends GeometricObject implements Colorable {
    private double side;
    
    public Square() {
        super();

        side = 0;
    }
    
    public Square(double side) {
        super();
        
        this.side = side;
    }
    
    @Override
    public double getArea() {
        return this.side * this.side;
    }

    @Override
    public void howToColor() {
        System.out.println("Раскрасьте все четыре стороны");
    }
    
    public void setSide(double side) { this.side = side; }
    public double getSide() { return this.side; }
}
