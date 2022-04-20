package View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {
    Scanner sc = new Scanner(System.in);
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
                str = sc.nextLine();
                if(!str.matches(regex)){
                    System.out.println(err);
                    continue;
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
                System.out.println(msg);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
                sdf.setLenient(false);
                date = sdf.parse(sc.nextLine());
                return sdf.format(date);
            }catch (Exception e){
                System.out.println(err);
            }
        }
    }
}
