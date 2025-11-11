package properties.inheritance;

public class Main {

    public static void main(String[] args) {

        Box box = new Box(4, 6, 6);
        box.Information();

        Rectangle rect = new Rectangle(3, 5, 7, 889);
        rect.Information();
        System.out.println(rect.h);
        System.out.println(rect.price);

        Rectangle rect2 = new Rectangle();
        System.out.println(rect2.l);
        System.out.println(rect2.price);

        Rectangle rect3 = new Rectangle(444);
        System.out.println(rect3.l);
        System.out.println(rect3.price);
    }
}
