package ss17_IO_BinaryFileAndSerialization.BaiTap.QuanLySanPhamLuuRaFileNhiPhan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
    private static  final  String path = "src\\ss17_IO_BinaryFileAndSerialization\\BaiTap\\QuanLySanPhamLuuRaFileNhiPhan\\product.bin";
    private static List<Product> productList = new ArrayList<>();

    public void writeFile(String path, List<Product> productList) {
        try {
            FileOutputStream output = new FileOutputStream(path);
            ObjectOutputStream objectOutput = new ObjectOutputStream(output);
            objectOutput.writeObject(productList);
            output.close();
            objectOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  List<Product> readFile(String path) {
        try {
            FileInputStream input = new FileInputStream(path);
            ObjectInputStream objectInput = new ObjectInputStream(input);
            productList = (List<Product>) objectInput.readObject();
            input.close();
            objectInput.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Empty");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
        writeFile(path, productList);
    }

    public void displayProduct() {
        for(Product product: productList) {
            System.out.println(product);
        }
    }

    public void searchProduct(int productId) {
        boolean check = false;
        for(int i = 0; i < productList.size(); i++) {
            if(productId == productList.get(i).getId()) {
                check = true;
                System.out.println("Product is found: ");
                System.out.println(productList.get(i).toString());
                break;
            }
        }
        if(!check) {
            System.out.println("Product is not found !");
        }
    }
}
