package View;

import Controllers.StudentController;

public class StudentView {
    StudentController controller = new StudentController();
    Validation validation = new Validation();
    public void List() {
        controller.getList();
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
            String getDate = validation.getDate("Enter DOB; ","Invalid,please re-enter !!!");
            String gender = validation.getString("Gender(M/F): ","Invalid,please re-enter !!!","^[mMfF]");
            int semester = validation.getInt("Enter Semester: ","Semester [1-9],please re-enter",1,9);
        }
    }

    public void Update() {
    }

    public void Delete() {
    }

    public void Search() {
    }
}
