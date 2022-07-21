package BaiThiModule2.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
    static Scanner scanner = new Scanner(System.in);

    public static final String REGEX_STR = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõ" +
            "ùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢ" +
            "ỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$";
    public static final String REGEX_VILLA = "^(SVVL)-\\d{4}$";
    public static final String REGEX_HOUSE = "^(SVHO)-\\d{4}$";
    public static final String REGEX_ROOM = "^(SVRO)-\\d{4}$";
    public static final String REGEX_AREA = "^([3-9][0-9]\\.*\\d*|\\d{3,}\\.*\\d*)$";
    public static final String REGEX_RENTALCOSTS = "^\\d+\\.*\\d*$";
    public static final String REGEX_MAXPEOPLE = "^([1-9]|1[0-9])$";
    public static final String REGEX_FLOORS = "^\\d+$";
    public static final String REGEX_PHONE_NUMBER = "^(\\+84|0)\\d{9}$";
    public static final String REGEX_EMAIL = "^[a-zA-Z][a-zA-Z0-9]+@gmail.com$";
    public static final String REGEX_BIRTHDAY = "^([0-2][0-9]|3[0|1])\\/(0[1-9]|1[0-2])\\/\\d{4}$";
    public static final String REGEX_NUMBERDOUBLE = "^\\d+\\.*\\d*$";
    public static final String REGEX_NUMBER = "^\\d+$";

    public static String regexStr(String temp, String regex, String error) {
        boolean flag = true;
        do {
            if(temp.matches(regex)) {
                flag = false;
            } else {
                System.out.println(error);
                temp = scanner.nextLine();
            }
        }while (flag);
        return temp;
    }

    //Kiểm tra ngày sinh
    public static String regexBirthday(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(temp, formatter);
                    LocalDate now = LocalDate.now();
                    int current = Period.between(age, now).getYears();
                    if (current < 100 && current > 18) {
                        check = false;
                        break;
                    } else {
                        throw new AgeCheckingException("Tuổi phải lớn hơn 18 và bé hơn 100");
                    }
                } else {
                    throw new AgeCheckingException("Định dạng nhập vào không đúng");
                }
            } catch (AgeCheckingException e) {
                System.out.println(e.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }

    public static String inputBirthday() {
        return Regex.regexBirthday(scanner.nextLine(), REGEX_BIRTHDAY);
    }

    public  static  String checkAddress(){
        return regexStr(scanner.nextLine(),REGEX_STR,"Nhập sai");
    }

    public static String checkName(){
        return regexStr(scanner.nextLine(),REGEX_STR,"Nhập sai");
    }

    public static String checkPhone(){
        return regexStr(scanner.nextLine(),REGEX_PHONE_NUMBER,"Nhập sai");
    }

    public static String checkEmail(){
        return regexStr(scanner.nextLine(),REGEX_EMAIL,"Nhập sai");
    }

    //Kiểm tra  mã ID
    public static  boolean checkEmployeeID(String x){
        String REGEX_EMPLOYEE_ID = "^(NV)-[0-9][0-9][0-9][1-9]$";
        boolean check = x.matches(REGEX_EMPLOYEE_ID);
        return  check;
    }

    public static  boolean checkStudentID(String x){
        String REGEX_CUSTOMER_ID = "^(HV)-[0-9][0-9][0-9][1-9]$";
        boolean check = x.matches(REGEX_CUSTOMER_ID);
        return  check;
    }

    public static  boolean checkIDCard(String x){
        String REGEX_ID = "^[0-9]{9}||[0-9]{12}$";
        boolean check = x.matches(REGEX_ID);
        return  check;
    }

    public static String inputIdVilla() {
        System.out.println("Nhập mã dịch vụ(Villa là SVVL-XXXX!) : ");
        return Regex.regexStr(scanner.nextLine(), REGEX_VILLA, "Bạn đã nhập sai mã dịch vụ, Villa là SVVL-XXXX!");
    }

    public static String inputIdHouse() {
        System.out.println("Nhập mã dịch vụ(House là SVHO-XXXX!): ");
        return Regex.regexStr(scanner.nextLine(), REGEX_HOUSE, "Bạn đã nhập sai mã dịch vụ!,House là SVHO-XXXX!");
    }

    public static String inputIdRoom() {
        System.out.println("Nhập mã dịch vụ(Room là SVRO-XXXX!): ");
        return Regex.regexStr(scanner.nextLine(), REGEX_ROOM, "Bạn đã nhập sai mã dịch vụ!,Room là SVRO-XXXX!");
    }

    public static String inputArea() {
        System.out.println("Nhập diện tích dịch vụ: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_AREA, "Bạn đã nhập sai diện tích dịch vụ!, diện tích lớn hơn 30m2");
    }

    public static String inputRentalCosts() {
        System.out.println("Nhập mã giá thuê: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_RENTALCOSTS, "Bạn đã nhập sai giá thuê!, phải là số dương");
    }

    public static String inputPepple() {
        System.out.println("Nhập số người thuê: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_MAXPEOPLE, "Bạn đã vượt quá số người dc thuê!, số người dc thuê < 20");
    }

    public static String inputRentalType() {
        System.out.println("Nhập kiểu thuê");
        return Regex.regexStr(scanner.nextLine(), REGEX_STR, "Bạn đã nhập sai định dạng, kiểu thuê phải viết hoa chữ cái đầu");
    }

    public static String inputStandard() {
        System.out.println("Nhập tiêu chuẩn");
        return Regex.regexStr(scanner.nextLine(), REGEX_STR, "Bạn đã nhập sai định dạng, tiêu chuẩn phải viết hoa chữ cái đầu");
    }

    public static String inputPool() {
        System.out.println("Nhập diện tích hồ bơi: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_AREA, "Bạn đã nhập sai diện tích hồ bơi!,diện tích lớn hơn 30m2");
    }

    public static String inputFloors() {
        System.out.println("Nhập số tầng: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_FLOORS, "Sai định dạng");
    }

    public static String inputServiceFree() {
        System.out.println("Nhập dịch vụ miễn phí:");
        return Regex.regexStr(scanner.nextLine(), REGEX_STR, "Bạn đã nhập sai định dạng, tiêu chuẩn phải viết hoa chữ cái đầu");
    }

    public static String inputNameService() {
        System.out.println("Nhập tên dịch vụ: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_STR, "Bạn đã nhập sai tên dịch vụ!");
    }

    public static String inputNumber() {
        return Regex.regexStr(scanner.nextLine(), REGEX_NUMBER, "Bạn đã nhập sai, xin hãy nhập số lớn hơn 0!");
    }

    public static String inputNumberDouble() {
        return Regex.regexStr(scanner.nextLine(), REGEX_NUMBERDOUBLE, "Bạn đã nhập sai, xin hãy nhập số lớn hơn 0!");
    }

    public static String regexDay(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                } else {
                    throw new AgeCheckingException("Định dạng nhập vào không đúng");
                }
            } catch (AgeCheckingException e) {
                System.out.println(e.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }
    public static String inputDay() {
        return Regex.regexDay(scanner.nextLine(), REGEX_BIRTHDAY);
    }
}

