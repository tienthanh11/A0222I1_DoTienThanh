package ss12_JavaCollectionFramework.BaiTap.LuyenTapSuDungArrayList_LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> productList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addNewProduct(String name, float price) {
        int lastId = 0;
        if(productList.size() > 0){
            lastId = productList.get(productList.size() - 1).getId();
        }
        Product product = new Product(lastId + 1, name, price);
        productList.add(product);

    }

    public void editProduct(int idEdit) {
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
    }

    public void removeProduct(int idRemove) {
        for(int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId() == idRemove) {
                productList.remove(productList.get(i));
                break;
            } else {
                System.out.println("Không có id cần xoá");
            }
        }
    }

    public void displayProduct() {
        for(Product product : productList) {
            System.out.println(product);
        }
    }

    public void searchProduct(String nameSP) {
/*        System.out.println("Nhập sản phẩm cần tìm: ");
        String strProduct = scanner.nextLine();*/

/*        ArrayList<Product> arrayList = new ArrayList<>();
        for(int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getName().toLowerCase().contains(strProduct.toLowerCase())) {
                arrayList.add(productList.get(i));
                System.out.println(arrayList);
            } else if(arrayList.size() == 0) {
                System.out.println("Không có sản phẩm");
            }
        }*/
        for (Product sp : productList) {
            if (sp.getName().indexOf(nameSP) >= 0){
                System.out.println(sp);
            }else {
                System.out.println("không có sản phẩm");
            }
        }
    }

    public void increase() {
        Collections.sort(productList);
    }

    public void decrease() {
        Product newProduct = new Product();
        Collections.sort(productList, newProduct);
    }

}
