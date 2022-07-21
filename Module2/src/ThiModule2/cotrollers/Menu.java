package ThiModule2.cotrollers;


import ThiModule2.model.DanhBa;
import ThiModule2.service.DanhBaService;
import ThiModule2.util.FileHelper;


import java.util.List;
import java.util.Scanner;


public class Menu {

    static Scanner scanner = new Scanner(System.in);
    static DanhBaService danhBaService = new DanhBaService();
    static FileHelper fileHelper = new FileHelper();
    private static final String PATH = "src\\ThiModule2\\data\\contacts.csv";


    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        while (true) {
            System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ---");
            System.out.println("Chọn chức năng theo số (để tiếp tục): ");
            System.out.println("1. Xem danh sách. ");
            System.out.println("2. Thêm mới. ");
            System.out.println("3. Cập nhật. ");
            System.out.println("4. Xoá. ");
            System.out.println("5. Tìm kiếm. ");
            System.out.println("6. Đọc từ file. ");
            System.out.println("7. Ghi từ file. ");
            System.out.println("8. Thoát.");
            System.out.println("--------------------------------------");
            System.out.println("Chọn chức năng: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    display();
                    break;
                case 2:
                    create();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    docFile();
                    break;
                case 7:
                    ghiFile();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void create() {
        System.out.println("Nhập số điện thoại: ");
        String soDienThoai = scanner.nextLine();
        System.out.println("Nhập nhóm của danh bạ: ");
        String nhom = scanner.nextLine();
        System.out.println("Nhập họ tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        String gioiTinh = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String diaChi = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String ngaySinh = scanner.nextLine();
        System.out.println("Nhâp email: ");
        String email = scanner.nextLine();
        DanhBa danhBa = new DanhBa(soDienThoai, nhom, name, gioiTinh, diaChi, ngaySinh, email);
        danhBaService.create(danhBa);
    }

    private static void edit() {
        System.out.println("Nhập số điện thoại muốn sửa: ");
        String sdtEdit = scanner.nextLine();
        danhBaService.editProduct(sdtEdit);
    }

    private static void delete() {
        System.out.println("Nhập số điện thoại muốn xoá: ");
        String sdtDelete = scanner.nextLine();
        String choose = scanner.nextLine();
        if(choose.equals("Y")) {
            danhBaService.delete(sdtDelete);
        } else {
            System.exit(0);
        }
    }

    private static void search() {
        System.out.println("Enter name to search: ");
        String name = scanner.nextLine();
        List<DanhBa> danhBas = danhBaService.search(name);

        if(danhBas.size() > 0) {
            for (DanhBa danhBa : danhBas) {
                System.out.println(danhBa);
            }
        } else {
            System.out.println("Empty list");
        }
    }

    private static void display() {
        List<DanhBa> danhBas = danhBaService.findAll();
        for (DanhBa danhBa : danhBas) {
            System.out.println(danhBa);
        }
    }

    private static void docFile() {
        System.out.println(fileHelper.read(PATH));
    }

    private static void ghiFile() {
       /* System.out.println(fileHelper.write(PATH, (List<DanhBa>) danhBaService,false));*/
    }
}
