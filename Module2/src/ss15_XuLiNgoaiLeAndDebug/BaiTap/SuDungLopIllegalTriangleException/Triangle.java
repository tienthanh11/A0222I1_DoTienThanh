package ss15_XuLiNgoaiLeAndDebug.BaiTap.SuDungLopIllegalTriangleException;

public class Triangle {
    protected double side1 = 1.0;
    protected double side2 = 1.0;
    protected double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        if(side1 < 0 || side2 < 0 || side3 < 0) {
            throw new IllegalTriangleException("side must more than zero");
        }
        if(side1 >= side2 + side3 || side2 >= side1 + side3 || side3 >= side1 + side2) {
            throw new IllegalTriangleException("sum of two sides must be greater than the other side");
        }
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getArea() {
        double p = (getPerimeter()) / 2;
        double area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        return area;
    }

    @Override
    public String toString() {
        return "Triangle {" +
                "side1 = " + side1 +
                ", side2 = " + side2 +
                ", side3 = " + side3 +
                '}';
    }
}
