package BaiTap.Bai2_HospitalManagement.util;

import java.util.Scanner;

public class Regex {
    Scanner scanner = new Scanner(System.in);
    public static String regexStr(String temp,String regex, String err)
    {   Scanner sc = new Scanner(System.in);
        boolean check = true;
        do {
            if (temp.matches(regex)){
                check = false;
            }
            else
            {
                System.out.println(err);
                temp = sc.nextLine();
            }
        }while (check);
        return temp;
    }

}
