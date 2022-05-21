package ss03_ArrayAndPhuongThucTrongJava.ThucHanh.b2;

import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a name's student: ");
        String name = scan.nextLine();
        boolean isExist = false;
        for(int i = 0; i < students.length; i++) {
            if(students[i].equals(name)) {
                System.out.println("Position of the student in the list " + name + " is: " + (i + 1));
                isExist = true;
                break;
            }
        }
        if(!isExist) {
            System.out.println("Not found " + name + " in the list");
        }
    }
}
