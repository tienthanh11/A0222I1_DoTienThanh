package demo.GiaiPhuongTrinh;

public class linear_equation {

    private double a;
    private double b;

    public String solve(double a, double b) {
        if(a == 0) {
            if(b == 0) {
                return "Phương trình vô số nghiệm";
            } else {
                return "Phương trình vô nghiệm";
            }
        } else {
            double x = -b / a;
            return "Phương trình có nghiệm duy nhất là: " + x;
        }
    }
}
