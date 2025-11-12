package properties.inheritance;

public class Rectangle extends Box{

    double price;

    Rectangle(double length, double width, double height, double price) {
        super(length, width, height);


        this.price = price;
    }

    Rectangle(){
        this.price = 98383;
    }

    Rectangle(double price){
        this.price = price;
    }


}
