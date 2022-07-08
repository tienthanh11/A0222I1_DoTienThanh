package ss19_StringAndRegex.BaiTap.ValidateClassName;

public class ClassNameTest {
    private static ClassName className;
    public static String[] validClassName = {"C0318G"};
    public static String[] invalidClassName = {"M00318G", "P0323A"};

    public static void main(String[] args) {
        className = new ClassName();
        for(String name : validClassName) {
            boolean isValid = className.validate(name);
            System.out.println("Class name is " + name + " is valid: " + isValid);
        }
        for(String name : invalidClassName) {
            boolean isValid = className.validate(name);
            System.out.println("Class name is " + name + " is valid: " + isValid);
        }
    }
}
