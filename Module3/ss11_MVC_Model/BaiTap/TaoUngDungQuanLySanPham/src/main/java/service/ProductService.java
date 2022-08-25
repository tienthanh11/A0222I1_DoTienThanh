package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {

    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Nokia 590", 1000, "Vip", "Nokia"));
        products.put(2, new Product(2, "Samsung A31", 2000, "Vip", "Samsung"));
        products.put(3, new Product(3, "IPhone 14 Pro Max", 3000, "Vip Pro", "IPhone"));
        products.put(4, new Product(4, "LG 180", 4000, "Vip", "LG"));
        products.put(5, new Product(5, "Honda 200", 5000, "Vip Pro", "Honda"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
//      Cách 1
        for(Product product : findAll()) {
            if(product.getName().contains(name)) {
                result.add(product);
            }
        }
        return result;

//        Cách 2
//        for(int i = 0; i < products.size(); i++) {
//            if(products.get(i).getName().contains(name)) {
//                result.add(products.get(i));
//            }
//        }
//        return result;

//        Cách 3
//        return findAll().stream().filter(e -> e.getName().contains(name)).collect(Collectors.toList());
    }
}
