package Generics.Comparable;

public class Student implements Comparable<Student>{

    int rollno;
    float marks;

    public Student(int rollno, float marks){
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student s){
        int diff = (int)(this.marks - s.marks);
        return diff;
    }
}
