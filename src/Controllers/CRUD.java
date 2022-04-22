package Controllers;

import Models.Student;

import java.util.List;

public interface CRUD {

    public int Create(int id, String name);


    public int Create(int id, String name, String dob, String gender, int semester, String course);

    public int Update(int id, Student student);

    public void Delete(int id);

    public int Search(int id);

}
