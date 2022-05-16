package ss01_IntroductionToJava.ThucHanh.b7;

import java.util.*;

public class TinhChiSoCanNangCuaCoThe {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        double weight, height, bmi;
        System.out.print("Your weight (in kilogam): ");
        weight = scanner.nextDouble();

        System.out.print("Your height (in meter): ");
        height = scanner.nextDouble();

        bmi = weight/ Math.pow(height, 2);
        System.out.printf("%-20s%s", "bmi", "Interpretation \n");

        if(bmi < 18.5) {
            System.out.printf("%-20.2f%s", bmi, "Underweight");
        } else if(bmi < 25.0){
            System.out.printf("%-20.2f%s", bmi, "Normal");
        } else if(bmi < 30.0) {
            System.out.printf("%-20.2f%s", bmi, "Overweight");
        } else {
            System.out.printf("%-20.2f%s", bmi, "Obese");
        }
    }
}
