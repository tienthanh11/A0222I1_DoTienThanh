package ss12_JavaCollectionFramework.ThucHanh.SapXepVoiComparableVaComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Thành", 21, "Đà Nẵng");
        Student student1 = new Student("Trí", 20, "Quảng Nam");
        Student student2 = new Student("Thư", 20, "Đà Nẵng");
        Student student3 = new Student("Thắng", 20, "Quảng Nam");

        List<Student> lists = new ArrayList<Student>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        Collections.sort(lists);
        for (Student st : lists) {
            System.out.println(st.toString());
        }

        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(lists, ageComparator);
        System.out.println("So sánh theo tuổi: ");
        for(Student st : lists) {
            System.out.println(st.toString());
        }
    }
}
