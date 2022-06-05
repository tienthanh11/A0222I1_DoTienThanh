package sss07_AbstractClassAndInterface.BaiTap.Resizeable;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        Circle circle = new Circle("indigo", false, 5);
        Rectangle rectangle = new Rectangle("red", true, 10, 20);
        Square square = new Square("yellow", true, 30);
        circle.resize(Math.random());
        rectangle.resize(Math.random());
        square.resize(Math.random());
        shape[0] = circle;
        shape[1] = rectangle;
        shape[2] = square;
        System.out.println(Arrays.toString(shape));
    }
}
