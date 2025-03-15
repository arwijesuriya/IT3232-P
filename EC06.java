/*
    Create a student class
        -create 5 student objects and store it in a proper data structure
        -Find the average marks of the students
*/

import java.util.ArrayList;

class Student {
    String studentName;
    int studentNumber;
    double marks;

    public Student(String studentName, int studentNumber, double marks) {
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.marks = marks;
    }
}

public class EC06 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Sanath", 101, 85.5));
        students.add(new Student("Aravinda", 102, 78.0));
        students.add(new Student("Kumar", 103, 92.5));
        students.add(new Student("Murali", 104, 88.0));
        students.add(new Student("Arjuna", 105, 79.5));

        // average marks
        double totalMarks = 0;
        for (Student studentName : students) {
            totalMarks += studentName.marks;
        }

        double averageMarks = totalMarks / students.size();
        
        System.out.println("Average Marks of Students: " + averageMarks);
    }
}
