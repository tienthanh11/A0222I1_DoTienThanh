package ss12_JavaCollectionFramework.BaiTap.LuyenTapSuDungArrayList_LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> productList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addNewProduct() {
        System.out.println("Nhập id sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sàn phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        float price = Float.parseFloat(scanner.nextLine());

        Product product = new Product(id, name, price);
        productList.add(product);
    }

    public void editProduct() {
        System.out.println("Nhập vào id muốn sừa: ");
        int idEdit = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId() == idEdit) {
                System.out.println("Nhập tên muốn sửa: ");
                String editName = scanner.nextLine();
                productList.get(i).setName(editName);
                System.out.println("Nhập giá muốn sửa: ");
                float editPrice = Float.parseFloat(scanner.nextLine());
                productList.get(i).setPrice(editPrice);
            } else {
                System.out.println("Không có sản phảm này");
            }
        }
        for(Product product : productList) {
            System.out.println(product);
        }
    }

    public void removeProduct() {
        System.out.println("Nhập id sản phẩm cần xoá: ");
        int idRemove = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId() == idRemove) {
                productList.remove(productList.get(i));
                break;
            } else {
                System.out.println("Không có id cần xoá");
            }
        }
        for(Product product : productList) {
            System.out.println(product);
        }
    }

    public void displayProduct() {
        for(Product product : productList) {
            System.out.println(product);
        }
    }

    public void searchProduct() {
        System.out.println("Nhập sản phẩm cần tìm: ");
        String strProduct = scanner.nextLine();

        ArrayList<Product> arrayList = new ArrayList<>();
        for(int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getName().toLowerCase().contains(strProduct.toLowerCase())) {
                arrayList.add(productList.get(i));
            }
        }
        if(arrayList.size() == 0) {
            System.out.println("Không có sản phẩm");
        } else {
            for (Product product : arrayList) {
                System.out.println(product);
            }
        }
    }

    public void increase() {
        Collections.sort(productList);
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void decrease() {
        Product newProduct = new Product();
        Collections.sort(productList, newProduct);
        for(Product product : productList) {
            System.out.println(product);
        }
    }
}
