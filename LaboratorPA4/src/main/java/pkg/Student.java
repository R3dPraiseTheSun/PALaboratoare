package pkg;

import java.util.Comparator;

public class Student {
    private String studentName;
    public Student(String name)
    {
        this.studentName = name;
    }

    public String getStudentName(){
        return this.studentName;
    }

    static class Sortbyname implements Comparator<Student>
    {
        public int compare(Student studentA, Student studentB)
        {
            return studentA.studentName.compareTo(studentB.studentName);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                '}';
    }
}
