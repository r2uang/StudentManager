import Controllers.StudentController;
import View.StudentView;
import View.Validation;

public class Main {
    public static void main(String[] args) {
        Validation validation = new Validation();
        StudentView studentView = new StudentView();
        while (true){
            Menu();
            int choice = validation.getInt("Enter option: ","Option[0-5]",0,5);
            switch (choice){
                case 1:
                    studentView.List();
                    break;
                case 2:
                    studentView.Create();
                    break;
                case 3:
                    studentView.Update();
                    break;
                case 4:
                    studentView.Delete();
                    break;
                case 5:
                    studentView.Search();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    private static void Menu() {
        System.out.println("----------------------");
        System.out.println("1. Display Students");
        System.out.println("2. Create Student");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Search Student");
        System.out.println("----------------------");
    }
}
