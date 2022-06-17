package ss11_DSA_StackAndQueue.BaiTap.ToChucDuLieuHopLy_DemergingSuDungQueue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng sinh viên: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        LinkedList<Student> listStudent = new LinkedList<>();
        for(int i = 0; i < count; i++) {
            System.out.println("Nhập tên sinh viên thứ " + (i + 1) + " : ");
            String name = scanner.nextLine();
            System.out.println("Nhập giới tính sinh viên thứ " + (i + 1) + " : ");
            String gender = scanner.nextLine();
            System.out.println("Nhập ngày tháng năm sinh sinh viên thứ (dd/mm/yyyy) " + (i + 1) + " : ");
            String birthdayStr = scanner.nextLine();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date birthday = format.parse(birthdayStr);
            Student student = new Student(name, birthday, gender);
            listStudent.add(student);
        }

        for(int i = 0; i < count; i++) {
            System.out.println("Thông tin sinh viên thứ " + (i + 1) + " : ");
            listStudent.get(i).showInfo();
        }

        sortList(listStudent);

        System.out.println("======Thông tin sau khi sắp xếp======");
        for(int i = 0; i < listStudent.size(); i++) {
            System.out.print("Thông tin sinh viên thứ " + (i + 1) + " : ");
            listStudent.get(i).showInfo();
        }

        Queue<Student> queueNu = new LinkedList<>();
        for(int i = 0; i < listStudent.size(); i++) {
            if(listStudent.get(i).getGender().equals("Nữ"));
            queueNu.add(listStudent.get(i));
        }

        Queue<Student> queueNam = new LinkedList<>();
        for(int i = 0; i < listStudent.size(); i++) {
            if(listStudent.get(i).getGender().equals("Nam"));
            queueNam.add(listStudent.get(i));
        }

        LinkedList<Student> list = new LinkedList<>();
        while (!queueNu.isEmpty()) {
            list.add(queueNu.poll());
        }
        while (!queueNam.isEmpty()) {
            list.add(queueNam.poll());
        }
        System.out.println("Sau khi tách nam và nữ là: ");
        for(Student student : list) {
            student.showInfo();
        }
    }

    private static void sortList(LinkedList<Student> listStudent) {
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o2.getBirthday().compareTo(o1.getBirthday()) > 0) {
                    return 1;
                } else if(o2.getBirthday().compareTo(o1.getBirthday()) < 0){
                    return -1;
                } else {
                    return (o2.getName().compareTo(o1.getName()));
                }
            }
        });
    }
}
