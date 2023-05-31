package kz.bitlab.springboot.techboot.db;
import kz.bitlab.springboot.techboot.db.Music;

import java.util.ArrayList;
import java.util.List;


public class DBManager {
    private static Long id = 7L;
    private static ArrayList<Student> students = new ArrayList<>();

    static {
        students = new ArrayList<>();
        students.add(new Student(1L, "John", "Doe", 85, "A"));
        students.add(new Student(2L, "Jane", "Smith", 73, "B"));
        students.add(new Student(3L, "Mike", "Johnson", 92, "C"));
        students.add(new Student(4L, "Emily", "Brown", 68, "D"));
        students.add(new Student(5L, "David", "Wilson", 79, "F"));
        students.add(new Student(6L, "Sarah", "Taylor", 95, "B"));
    }

    public static void addStudent(Student student) {
        if (student.getExam() >= 90) {
            student.setMark("A");

        } else if (student.getExam() >= 75) {
            student.setMark("B");
        } else if (student.getExam() >= 60) {
            student.setMark("C");
        } else if (student.getExam() >= 50) {
            student.setMark("D");
        } else {
            student.setMark("F");
        }
        student.setId(id++);
        students.add(student);
    }

    public static Student getStudent(int id) {
        return students.stream().filter(student -> student.getId()==id).findFirst().orElse(null);

    }

        public static ArrayList<Student> getStudents(){
        return students;
    }

}
