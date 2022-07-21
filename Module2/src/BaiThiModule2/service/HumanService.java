package BaiThiModule2.service;

import BaiThiModule2.model.Employee;
import BaiThiModule2.model.Human;
import BaiThiModule2.model.Student;
import BaiThiModule2.util.ReadAndWrite;
import BaiThiModule2.util.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanService implements HumanServiceImpl {
    static Scanner scanner = new Scanner(System.in);
    public static final String PATH = "src\\BaiThiModule2\\data\\personal_record.csv";

    @Override
    public void addNew() {
        do {
            System.out.println("*----- Thêm mới -----*");
            System.out.println("* 1. Thêm nhân viên. *");
            System.out.println("* 2. Thêm hội viên.  *");
            System.out.println("* 3. Quay lại menu.  *");
            System.out.println("*--------------------*");
            System.out.println("Nhập lựa chọn: ");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    addNewEmployee();
                    break;
                case "2":
                    addNewStudent();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Chỉ chọn 1 - 3");
            }
        } while (true);
    }

    private void addNewEmployee() {
        String id;
        while (true) {
            System.out.println("Nhập mã nhân viên (NV-xxxx): ");
            id = scanner.nextLine();
            if (Regex.checkEmployeeID(id)) {
                break;
            } else {
                System.out.println("Mã nhân viên nhập sai");
            }
        }
        System.out.println("Nhập họ và tên nhân viên: ");
        String fullName = Regex.checkName();
        System.out.println("Nhập ngày sinh(dd/MM/yyyy): ");
        String birthday = Regex.inputBirthday();
        System.out.println("Nhập địa chỉ: ");
        String address = Regex.checkAddress();
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = Regex.checkPhone();
        System.out.println("Nhập lương: ");
        String salary = Regex.inputNumber();
        System.out.println("Nhập bộ phận làm viêc: ");
        String department = Regex.checkName();
        System.out.println("Nhập vị trí làm việc: ");
        String job = Regex.checkName();
        List<Human> humanList = new ArrayList<>();
        Employee employee = new Employee(id, fullName, birthday, address, phoneNumber, salary, department, job);
        humanList.add(employee);
        ReadAndWrite.writeList(humanList, PATH, true);
        System.out.println("Thêm mới thành công");
    }

    private void addNewStudent() {
        String id;
        while (true) {
            System.out.println("Nhập mã học viên (HV-xxxx): ");
            id = scanner.nextLine();
            if (Regex.checkStudentID(id)) {
                break;
            } else {
                System.out.println("Mã học viên nhập sai");
            }
        }
        System.out.println("Nhập họ và tên học viên: ");
        String fullName = Regex.checkName();
        System.out.println("Nhập ngày sinh(dd/MM/yyyy): ");
        String birthday = Regex.inputBirthday();
        System.out.println("Nhập địa chỉ: ");
        String address = Regex.checkAddress();
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = Regex.checkPhone();
        System.out.println("Nhập điểm thi: ");
        String scored = Regex.inputNumber();
        System.out.println("Nhập tên lớp: ");
        String className = scanner.nextLine();
        System.out.println("Nhập ngày nhập học: ");
        String dayJoint = scanner.nextLine();
        List<Human> humanList = new ArrayList<>();
        Student student = new Student(id, fullName, birthday, address, phoneNumber, scored, className, dayJoint);
        humanList.add(student);
        ReadAndWrite.writeList(humanList, PATH, true);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void delete() {
        boolean flag = false;
        List<Human> humanList = ReadAndWrite.readList(PATH);
        System.out.println("Nhập id cần xoá: ");
        String id = scanner.nextLine();
        for(Human human : humanList) {
            if(human.getId().equals(id)) {
                System.out.println(human);
                System.out.println("Bạn muốn xoá hay không:");
                System.out.println("1. Xoá");
                System.out.println("2. Không xoá");
                System.out.println("nhập lựa chọn: ");
                int choose = Integer.parseInt(scanner.nextLine());
                if(choose == 1) {
                    flag = true;
                    humanList.remove(human);
                    System.out.println("Đã xoá");
                    ReadAndWrite.writeList(humanList, PATH, false);
                    System.out.println("Cập nhật thành công");
                    break;
                } else if(choose == 2) {
                    System.out.println("Không xoá");
                    display();
                    break;
                } else {
                    try {
                        throw new NumberFormatException("Không đúng định dạng");
                    } catch (NumberFormatException e) {
                        System.out.println("Chỉ chọn 1 hoặc 2");
                    }
                    break;
                }
            }
        }
    }

    @Override
    public void display() {
        List<Human> humanList = ReadAndWrite.readList(PATH);
        if(humanList.isEmpty()) {
            System.out.println("Chưa có tài khoản được thêm vào: ");
        } else {
            for(Human human: humanList) {
                System.out.println(human);
            }
        }
    }
}
