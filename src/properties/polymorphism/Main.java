package properties.polymorphism;

public class Main {

    public static void main(String[] args) {

        Shapes shape = new Shapes();
        shape.area();

        Circle circle = new Circle();
        circle.area();

        Square square = new Square();
        square.area();

        Triangle triangle = new Triangle();
        triangle.area();
    }
}
