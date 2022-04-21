package Models;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String dob;
    private String gender;
    private int semester;
    private String course;

    public Student() {
    }

    public Student(int id, String name, String dob, String gender, int semester, String course) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.semester = semester;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", semester=" + semester +
                ", course='" + course + '\'' +
                '}';
    }
}
