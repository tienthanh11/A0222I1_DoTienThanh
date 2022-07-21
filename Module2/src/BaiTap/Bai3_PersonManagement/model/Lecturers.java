package BaiTap.Bai3_PersonManagement.model;

public class Lecturers extends Person {
    private String specializes;

    public Lecturers() {
    }

    public Lecturers(String id, String name, String birthday, String gender, String specializes) {
        super(id, name, birthday, gender);
        this.specializes = specializes;
    }

    public String getSpecializes() {
        return specializes;
    }

    public void setSpecializes(String specializes) {
        this.specializes = specializes;
    }

    @Override
    public String toString() {
        return "Lecturers{" +
                super.toString() +
                "specializes='" + specializes + '\'' +
                '}';
    }
}
