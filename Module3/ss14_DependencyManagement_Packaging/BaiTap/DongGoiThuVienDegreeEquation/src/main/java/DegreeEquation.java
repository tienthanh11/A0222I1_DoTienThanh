import java.security.NoSuchAlgorithmException;

public class DegreeEquation {
    public static void main(String[] args) {
        try {
            System.out.println(DegreeEquation.Equation(1, 2, 3));
            System.out.println(DegreeEquation.Equation(2,-7,3));
            System.out.println(DegreeEquation.Equation(1,-4,4));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    public static int Equation(float a, float b, float c) throws NoSuchAlgorithmException {
        if(a == 0) {
            if(b == 0) {
                throw new NoSuchAlgorithmException();
            } else {
                System.out.println("Phương trình có một nghiệm: x = " + (-c / b));
            }
        }

        float delta = b * b - 4 * a * c;
        float x1;
        float x2;

        if(delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            System.out.println("Phương trình có 2 nghiệm là: "
                    + "x1 = " + x1 + " và x2 = " + x2);
        } else if(delta == 0) {
            x1 = (-b / (2 * a));
            System.out.println("Phương trình có nghiệm kép: "
                    + "x1 = x2 = " + x1);
        } else {
            throw new NoSuchAlgorithmException();
        }
        return 0;
    }
}
