package View;

import Controllers.CourseController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {
    Scanner sc = new Scanner(System.in);
    CourseController controller = new CourseController();
    public int getInt(String msg, String err, int min, int max) {
        while (true){
            try{
                System.out.print(msg);
                int num = Integer.parseInt(sc.nextLine());
                if(num < min || num > max){
                    System.out.println(err);
                    continue;
                }
                return num;
            }catch (Exception e){
                System.out.println(err);
            }
        }
    }

    public String getString(String msg, String err, String regex) {
        while (true){
            try{
                String str;
                System.out.print(msg);
                str = sc.nextLine().trim();
                if(!str.matches(regex)){
                    System.out.println(err);
                }else{
                    return str;
                }
            }catch (Exception e){
                System.out.println(err);
            }
        }
    }

    public String getDate(String msg,String err){
        while (true){
            try {
                Date date;
                System.out.print(msg);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
                sdf.setLenient(false);
                date = sdf.parse(sc.nextLine());
                return sdf.format(date);
            }catch (Exception e){
                System.out.println(err);
            }
        }
    }

    public String getCourse(String msg, String err) {
        while (true){
            try{
                System.out.print(msg);
                String course = sc.nextLine().trim();
                if(controller.checkCourseExist(course)){
                    return course;
                }else{
                    System.out.println(course + err);
                }
            }catch (Exception e){
                System.out.println(err);
            }
        }
    }

    public String getGender(String msg, String err, String regex) {
        while (true){
            try{
                System.out.print(msg);
                String gender = sc.nextLine();
                if(!gender.matches(regex)){
                    System.out.println(err);
                    continue;
                }else{
                    if(gender.equalsIgnoreCase("m")){
                        gender = "Male";
                    }else{
                        gender = "Female";
                    }
                }
                return gender;
            }catch (Exception e){
                System.out.println(err);
            }
        }
    }

    public int getUpdateSemester() {
        int semester;
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                semester = -1;
                break;
            }
            if (!input.matches("^[0-9]*$")) {
                System.out.print("Please re-input: ");
            } else {
                semester = Integer.parseInt(input);
                break;
            }
        }
        return semester;
    }
}
