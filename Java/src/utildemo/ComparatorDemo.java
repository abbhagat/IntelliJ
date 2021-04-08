package utildemo;

import java.util.*;

class Student1 {

    private String name;
    private int marks;
    private Date dob;

    Student1(String name, int marks, Date dob) {
        this.name = name;
        this.marks = marks;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDob() {
        return dob;
    }
}

class NameCompartor implements Comparator<Student1> {
    public int compare(Student1 s1, Student1 s2) {
        return (s1.getName().compareTo(s2.getName()));
    }
}

class DateComparator implements Comparator<Student1> {

    public int compare(Student1 s1, Student1 s2) {
        return s1.getDob().compareTo(s2.getDob());
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Student1 s1 = new Student1("A", 99, cal.getTime());
        cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 15);
        Student1 s2 = new Student1("X", 90, cal.getTime());
        cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 5);
        Student1 s3 = new Student1("M", 85, cal.getTime());
        cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 20);
        Student1 s4 = new Student1("N", 93, cal.getTime());
        cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 2);
        Student1 s5 = new Student1("O", 97, cal.getTime());
        List<Student1> al = new ArrayList<>();
        al.add(s1);
        al.add(s2);
        al.add(s3);
        al.add(s4);
        al.add(s5);
        System.out.println(al);
        Collections.sort(al, new NameCompartor());
        for (Student1 s : al) {
            System.out.println(s.getName() + "\t" + s.getMarks() + "\t" + s.getDob());
        }
        System.out.println();
        Collections.sort(al, new Comparator<Student1>() {
            public int compare(Student1 m1, Student1 m2) {
                return m1.getMarks() - m2.getMarks();
            }
        });
        for (Student1 s : al) {
            System.out.println(s.getName() + "\t" + s.getMarks() + "\t" + s.getDob());
        }
        System.out.println();
        Comparator<Student1> dateComparator = (stud1, stud2) -> stud2.getDob().compareTo(stud1.getDob());
        Collections.sort(al, dateComparator);
        for (Student1 s : al) {
            System.out.println(s.getName() + "\t" + s.getMarks() + "\t" + s.getDob());
        }
    }
}
