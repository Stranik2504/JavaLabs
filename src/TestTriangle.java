public class TestTriangle {
    public static void main(String[] args) throws IllegalTriangleException {
        // Task 1
        System.out.print("Введите первую сторону треугольника: ");
        var side1 = Integer.parseInt(System.console().readLine());

        System.out.print("Введите вторую сторону треугольника: ");
        var side2 = Integer.parseInt(System.console().readLine());

        System.out.print("Введите третью сторону треугольника: ");
        var side3 = Integer.parseInt(System.console().readLine());

        System.out.print("Введите цвет фигуры: ");
        var color = System.console().readLine();

        System.out.print("Введите закрашена ли она: ");
        var filled = Boolean.parseBoolean(System.console().readLine());
        
        var triangle = new Triangle(side1, side2, side3);
        
        triangle.setColor(color);
        triangle.setFilled(filled);
        
        System.out.println("Треугольник " + triangle.toString());
        System.out.println("Площадь равна " + triangle.getArea());
        System.out.println("Периметр равен " + triangle.getPerimeter());

        // Task 2
        try {
            triangle = new Triangle(1, 1, 1);
        }
        catch (IllegalTriangleException ex) {
            System.out.println("IllegalTriangleException is gotten");
        }
    }
}
