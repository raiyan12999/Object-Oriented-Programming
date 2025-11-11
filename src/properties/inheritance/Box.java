package properties.inheritance;

public class Box {

    double l;
    double w;
    double h;

    void Information(){
        System.out.println("Length of Box: " + this.l + " width: " + this.w + " height: " + this.h);
    }

    Box(double length, double width, double height){

        this.l = length;
        this.w = width;
        this.h = height;

    }

    Box(){
        double l;
        double w;
        double h;

    }
}
