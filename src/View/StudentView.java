package View;

import Controllers.CourseController;
import Controllers.StudentController;
import Models.Student;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class StudentView {
    StudentController controller = new StudentController();
    CourseController courseController = new CourseController();
    Validation validation = new Validation();
    public void List() {
        controller.displayListStudent();
    }

    public void Create() {
        while(true){
            int count = controller.getListSize();
            if(count >= 10){
                String choice = validation.getString("Choice(Y/N): ","Invalid,please re-enter only(Y/N)","^[yYnN]");
                if(choice.equals("n") || choice.equals("N")){
                    break;
                }
            }
            int id = 1;
            if(count != 0){
                id = controller.getList().get(controller.getListSize() - 1).getId() + 1;
            }
            String name = validation.getString("Enter name: ","Invalid,please re-enter !!!","[a-zA-Z ]+");
            String dob = validation.getDate("Enter DOB: ","Invalid,please re-enter !!!");
            String gender = validation.getGender("Gender(M/F): ","Invalid,please re-enter !!!","^[mMfF]");
            int semester = validation.getInt("Enter Semester: ","Semester [1-9],please re-enter",1,9);
            courseController.displayListCourse();
            String course = validation.getCourse("Enter Course: "," course doesn't exist");
            controller.Create(id,name,dob,gender,semester,course);
            System.out.println("Add Successfully");
            count++;
            break;
        }
    }

    public void Update() {
        if(controller.checkListIsEmpty() == -1){
            System.out.println("List Empty");
            return;
        }
        controller.displayListStudent();
        List<Student> studentListUpdate = new ArrayList<>();
        int student_id = validation.getInt("Enter Student ID: ","Student ID does not exist ",1, Integer.MAX_VALUE);
        if (controller.checkIdExisted(student_id) == -1) {
            System.out.println("Student not exist");
        }
        for (Student s: controller.getList()) {
            if(s.getId() == student_id){
                studentListUpdate.add(s);
            }
        }
        controller.displayListStudentByIndex(studentListUpdate);
        int index = validation.getInt("Choose index you want to update: ","Student does not exist ",1, studentListUpdate.size());
        int indexStudent = controller.findStudent(studentListUpdate.get(index - 1));
        Student studentUpdate = controller.getStudentByIndex(indexStudent);
        String oldName = studentUpdate.getName();
        System.out.print("Enter Name: ");
        String newName = validation.getUpdateName();
        if (newName.isEmpty()){
            newName = studentUpdate.getName();
        }
        System.out.print("Enter Semester: ");
        int newSemester = validation.getUpdateSemester();
        if (newSemester == -1) {
            newSemester = studentUpdate.getSemester();
        }
        System.out.println(newSemester);
        courseController.displayListCourse();
        System.out.print("Enter Course: ");
        String newCourse = validation.getUpdateCourseName();
        if (newCourse.isEmpty()) {
            newCourse = studentUpdate.getCourse();
        }
        if (controller.isStudentExisted(student_id, newName, newSemester, newCourse) == true) {
            System.out.println("Duplicates Information");
            return;
        } else if (checkUpdateStudentExisted(student_id, newSemester, newCourse) == false) {
            for (Student st : studentListUpdate) {
                if (st.getName().equals(oldName)) {
                    st.setName(newName);
                }
            }
            studentUpdate.setSemester(newSemester);
            studentUpdate.setCourse(newCourse);
        } else {
            for (Student st : studentListUpdate) {
                if (st.getName().equals(oldName)) {
                    st.setName(newName);
                }
            }
        }
        controller.Update(indexStudent, studentUpdate);
        controller.displayListStudentByIndex(studentListUpdate);
        System.out.println("Update Successfully");

    }

    public void Delete() {
        if(controller.checkListIsEmpty() == -1){
            System.out.println("List Empty");
            return;
        }
        controller.displayListStudent();
        int student_id = validation.getInt("Enter Student ID: ","Student ID does not exist ",1, controller.getListSize());
        controller.Delete(student_id);
    }

    public void Search() {
        if(controller.checkListIsEmpty() == -1){
            System.out.println("List Empty");
            return;
        }
        while (true){
            System.out.println("1.Search By Id");
            System.out.println("2.Search By Name");
            System.out.println("3.Search By Course");
            System.out.println("0. Exit");
            int choice = validation.getInt("Enter Choice: ","Option[0-3] ",0, 3);
            switch (choice){
                case 1:
                    int student_id = validation.getInt("Enter Student ID: ","Student ID does not exist ",1, controller.getListSize());
                    controller.searchStudentID(student_id);
                    return;
                case 2:
                    String student_name = validation.getString("Enter name: ","Invalid,please re-enter !!!","[a-zA-Z ]+");
                    controller.searchStudentByName(student_name);
                    return;
                case 3:
                    String course = validation.getCourse("Enter Course: "," course doesn't exist");
                    controller.searchStudentByCourse(course);
                    return;
                case 0:
                    return;
            }

        }
    }
    public boolean checkUpdateStudentExisted(int id, int newSemester, String newCourse) {
        for (Student st : controller.getList()) {
            if (st.getId() == id && st.getSemester() == newSemester && st.getCourse().equals(newCourse)) {
                return true;
            }
        }
        return false;
    }
}
