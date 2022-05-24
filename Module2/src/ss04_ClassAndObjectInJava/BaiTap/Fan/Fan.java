package ss04_ClassAndObjectInJava.BaiTap.Fan;

public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed = SLOW;
    private boolean isOn = false;
    private double radius = 5;
    private String color = "blue";

    Fan() {

    }

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public void setMaxSpeed() {
        this.speed = this.FAST;
    }
    public void setMediumSpeed() {
        this.speed = this.MEDIUM;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        this.isOn = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String display;
        if(this.isOn()) {
            display = "Fan in on{" +
                    "speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        } else {
            display = "Fan in off{" +
                    "radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        }
        return display;
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setMaxSpeed();
        fan1.radius = 10;
        fan1.color = "yellow";
        fan1.isOn = true;

        Fan fan2 = new Fan();
        fan2.setMediumSpeed();
        fan2.radius = 5;

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }

}