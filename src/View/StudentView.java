package service;

import Controllers.CourseController;
import Controllers.StudentController;

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
            String course = validation.getCourse("Enter Course: ","Course['Java','.Net','C++','C#']");
            controller.Create(id,name,dob,gender,semester,course);
            System.out.println("Add Successfully");
            count++;
            break;
        }
    }

    public void Update() {

    }

    public void Delete() {
    }

    public void Search() {
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
                    String course = validation.getCourse("Enter Course: ","Course['Java','.Net','C++','C#']");
                    controller.searchStudentByCourse(course);
                    return;
                case 0:
                    return;
            }

        }

    }
}
