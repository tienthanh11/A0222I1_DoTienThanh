package ss05_AccessModifier_StaticMethod_StaticProperty.BaiTap.AccessModifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(6);
        System.out.println("Radius is: " + circle.getRadius());
        System.out.println("Area is: " + circle.getArea());
    }
}
