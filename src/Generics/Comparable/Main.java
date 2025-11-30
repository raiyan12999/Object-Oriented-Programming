package Generics.Comparable;

public class Main {
    public static void main(String[] args) {
        Student raiyan = new Student(17, 96.5f);
        Student afifa = new Student(28, 96.5f);

        if(raiyan.compareTo(afifa) < 0){
            System.out.println("Afifa has more marks");
        } else if(raiyan.compareTo(afifa) > 0) {
            System.out.println("Raiyan has more marks");
        } else {
            System.out.println("Both has equal marks");
        }
    }
}
