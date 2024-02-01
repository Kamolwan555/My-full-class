package th.co.cdgs.studentGrade;

import java.util.List;

public class Student {

    private String name;
    private int score;
    private String grade;

    public Student() {
        // Default constructor
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void grade(List<Student> students) {
        for (Student student : students) {
            int score = student.getScore();
            if (score >= 80) {
                student.setGrade("A");
            } else if (score >= 70) {
                student.setGrade("B");
            } else if (score >= 60) {
                student.setGrade("C");
            } else if (score >= 50) {
                student.setGrade("D");
            } else {
                student.setGrade("F");
            }
        }
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}