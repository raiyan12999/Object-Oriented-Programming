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

        Student student2 = new Student(12000, "Afifa", 98);

        System.out.println(student2.rno);
        System.out.println(student2.name);
        System.out.println(student2.marks);

        Student student3 = new Student(35, "Bolbona");

        System.out.println(student3.rno);
        System.out.println(student3.name);
        System.out.println(student3.marks);
    }
}

class Student {

    int rno;
    String name;
    int marks;

    Student (){
        int rno;
        String name;
        int marks;
    }

    Student (int rollNo, String givenName, int points){
        rno = rollNo;
        name = givenName;
        marks = points;
    }

    Student (int rollNo, String givenName){
        rno = rollNo;
        name = givenName;

    }
}