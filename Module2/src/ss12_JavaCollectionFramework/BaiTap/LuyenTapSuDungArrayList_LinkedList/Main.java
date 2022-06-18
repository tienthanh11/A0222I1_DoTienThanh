package ss12_JavaCollectionFramework.BaiTap.LuyenTapSuDungArrayList_LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--------MENU---------");
            System.out.println("1. Thêm sản phẩm: ");
            System.out.println("2. Sủa thông tin sản phảm theo id: ");
            System.out.println("3. Xoá sản phẩm theo id: ");
            System.out.println("4. Hiển thị danh sách sản phẩm: ");
            System.out.println("5. Tìm kiếm sản phẩm theo tên: ");
            System.out.println("6. Sắp xếp sản phẩm tăng dần theo giá: ");
            System.out.println("7. Sắp xếp sản phẩm giảm dần theo giá: ");
            System.out.println("0. Exit: ");

            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    manager.addNewProduct();
                    break;
                case 2:
                    manager.editProduct();
                    break;
                case 3:
                    manager.removeProduct();
                    break;
                case 4:
                    manager.displayProduct();
                    break;
                case 5:
                    manager.searchProduct();
                    break;
                case 6:
                    manager.increase();
                    break;
                case 7:
                    manager.decrease();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
