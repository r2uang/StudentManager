package Controllers;

import Models.Course;
import Models.Student;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class StudentController implements CRUD {
    List<Student> list;

    public StudentController() {
        list = new ArrayList<>();
        list.add(new Student(1, "Nguyen Van A", "01-01-2001", "Male", 6, "Java"));
        list.add(new Student(2, "Nguyen Van B", "02-02-2001", "Female", 7, ".Net"));
        list.add(new Student(3, "Nguyen Van C", "03-03-2001", "Male", 8, "C++"));
        list.add(new Student(4, "Nguyen Van D", "04-04-2001", "Female", 9, "C#"));
    }

    public void displayListStudent() {
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }

    public List<Student> getList() {
        return list;
    }

    public int getListSize() {
        return list.size();
    }

    @Override
    public int Create(int id, String name) {
        return 0;
    }

    @Override
    public int Create(int id, String name, String dob, String gender, int semester, String course) {
        Student student = new Student(id, name, dob, gender, semester, course);
        try {
            list.add(student);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int Update(int id) {
        return 0;
    }

    @Override
    public void Delete(int id) {
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if (student.getId() == id) {
                list.remove(student);
            }
        }
        displayListStudent();
    }

    @Override
    public int Search(int id) {
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if (student.getId() == id) {
                return i;
            }
        }
        return 0;
    }
    public int checkListIsEmpty() {
        if (list.isEmpty()) {
            return -1;
        }
        return 1;
    }
    public void searchStudentID(int student_id) {
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if (student.getId() == student_id) {
                System.out.println(student.toString());
            }else {
                System.out.println("ID: "+ student_id +" Not exist!!");
            }
        }
    }

    public void searchStudentByName(String student_name) {
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if (student.getName().toLowerCase().contains(student_name.toLowerCase().trim())) {
                System.out.println(student.toString());
            }else{
                System.out.println("Nothing Found !!!");
            }
        }
    }

    public void searchStudentByCourse(String course) {
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if (student.getCourse().equalsIgnoreCase(course.trim())) {
                System.out.println(student.toString());
                found = true;
            }
        }
        if(!found){
            System.out.println("Not Found");
        }
    }

    public void displayListStudentByIndex(List<Student> studentListUpdate) {
        System.out.println("----------------");
        int count = 1;
        for (Student s: studentListUpdate) {
            System.out.print(count);
            System.out.println(s.toString());
            count++;
            System.out.println("");
        }
    }

    public Student getStudentByIndex(int index) {
        if (index < 0) {
            return null;
        }
        if (index < list.size()) {
            return list.get(index);
        }
        return null;
    }

    public boolean isStudentExisted(int id, String newName, int newSemester, String newCourse) {
        for (Student student : list) {
            if (student.getId() == id && student.getName().equalsIgnoreCase(newName)
                    && student.getSemester() == newSemester && student.getCourse().equalsIgnoreCase(newCourse)) {
                return true;
            }
        }
        return false;
    }

    public int UpdateOrDelete(int index, Student studentUpdate) {
        if (index < 0) {
            return -1;
        }
        list.set(index, studentUpdate);
        return 1;
    }
}


