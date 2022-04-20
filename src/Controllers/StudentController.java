package Controllers;

import Models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentController implements CRUD {
    List<Student> list;

    public StudentController() {
        list = new ArrayList<>();
        list.add(new Student(1,"Nguyen Van A","01-01-2001","Male",6,"Java"));
        list.add(new Student(1,"Nguyen Van A","01-01-2001","Male",6,"Java"));
        list.add(new Student(1,"Nguyen Van A","01-01-2001","Male",6,"Java"));
        list.add(new Student(1,"Nguyen Van A","01-01-2001","Male",6,"Java"));
    }

    public List<Student> getList(){
        return list;
    }
    public int getListSize(){
        return list.size();
    }
    @Override
    public int Create() {
        return 0;
    }

    @Override
    public int Update() {
        return 0;
    }

    @Override
    public int Delete() {
        return 0;
    }
}

