package ss06_KeThua.BaiTap.ClassPoint2DAndClassPoint3D;

public class Point3D extends Point2D{
    private float z = 0.0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] array = new float[3];
        array[0] = this.getX();
        array[1] = this.getY();
        array[2] = this.z;
        return array;
    }

    @Override
    public String toString() {
        return "Point3D {" +
                "x = " + getX() +
                ", y = " + getY() +
                ", z = " + getZ() +
                '}';
    }
}
