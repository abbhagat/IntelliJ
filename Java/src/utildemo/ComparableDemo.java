package utildemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {

    private String name;
    private int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int compareTo(Student s) {
        // return(this.getMarks()-s.getMarks());
        // return(s.getMarks()-this.getMarks());
        return (s.getName().compareTo(this.getName())); // sorted in descending order
        // return(this.getName().compareTo(s.getName())); // sorted in ascending order
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public String toString() {
        return this.getName() + "  " + this.getMarks();
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        Student s1 = new Student("A", 99);
        Student s2 = new Student("X", 90);
        Student s3 = new Student("M", 85);
        Student s4 = new Student("N", 93);
        Student s5 = new Student("O", 97);
        List<Student> al = new ArrayList<>();
        al.add(s1);
        al.add(s2);
        al.add(s3);
        al.add(s4);
        al.add(s5);
        Collections.sort(al);
        System.out.println(al);
    }
}
