public class Main {

    public static void main(String[] args) {
        System.out.println("Hello!");

        Student student1 = new Student();
        System.out.println(student1.rno);
        System.out.println(student1.name);
        System.out.println(student1.marks);

        student1.rno = 12999;
        student1.name = "Raiyan";
        student1.marks = 89;

        System.out.println(student1.rno);
        System.out.println(student1.name);
        System.out.println(student1.marks);
    }
}

class Student {

    int rno;
    String name;
    int marks;


}