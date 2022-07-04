package ss17_IO_BinaryFileAndSerialization.BaiTap.QuanLySanPhamLuuRaFileNhiPhan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManagement myProduct = new ProductManagement();
        int choice;
        do {
            System.out.println("====== PRODUCT MANAGEMENT SYSTEM ======");
            System.out.println("1. Add new product");
            System.out.println("2. Display product");
            System.out.println("3. Search product");
            System.out.println("0. Exit");

            System.out.println("Please input your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Please enter code: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please enter product's name: ");
                    String productName = scanner.nextLine();
                    System.out.println("Please enter product's manufacturer: ");
                    String manufacturer = scanner.nextLine();
                    System.out.println("Please enter product's price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.println("Please enter other description: ");
                    String description = scanner.nextLine();
                    Product product = new Product(id, productName, manufacturer, price, description);
                    myProduct.addProduct(product);
                    System.out.println("Created successfully");
                    break;
                case 2:
                    System.out.println("------ Product List ------");
                    myProduct.displayProduct();
                    break;
                case 3:
                    System.out.println("Please enter product's code which you need to search: ");
                    int productId = Integer.parseInt(scanner.nextLine());
                    myProduct.searchProduct(productId);
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
