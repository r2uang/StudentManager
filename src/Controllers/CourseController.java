package Controllers;

import Models.Course;
import Models.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseController implements CRUD {
    List<Course> courses;

    public CourseController() {
        courses = new ArrayList<>();
        courses.add(new Course(1, "Java"));
        courses.add(new Course(2, ".Net"));
        courses.add(new Course(3, "C++"));
        courses.add(new Course(4, "C#"));
    }

    public void displayListCourse() {
        System.out.println("------Available course------");
        for (Course course : courses) {
            System.out.println(course.toString());
        }
    }

    public  boolean checkCourseExist(String str){
        for (Course course: courses) {
            if(course.getCourse_name().equalsIgnoreCase(str)){
                return true;
            }
        }
        return false;
    }
    public List<Course> getList() {
        return courses;
    }
    @Override
    public int Create(int id, String name) {
        return 0;
    }

    @Override
    public int Create(int id, String name, String dob, String gender, int semester, String course) {
        return 0;
    }

    @Override
    public int Update(int id, Student student) {
        return 0;
    }

    @Override
    public void Delete(int id) {
    }

    @Override
    public int Search(int id) {
        return 0;
    }
}
