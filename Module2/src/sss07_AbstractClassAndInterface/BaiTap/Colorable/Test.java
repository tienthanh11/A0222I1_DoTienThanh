package sss07_AbstractClassAndInterface.BaiTap.Colorable;

public class Test {
    public static void main(String[] args) {
        Square square = new Square("red", true, 30);
        System.out.println(square.toString());
        square.howToColor();
    }
}