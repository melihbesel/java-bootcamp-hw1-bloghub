package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    private static ProductRepository lazySingleton;

    private ProductRepository(){
        System.out.println("ProductRepository sınıfından bir nesne oluşturuldu.");
    }

    public static ProductRepository getInstance(){
        if (lazySingleton == null){
            lazySingleton = new ProductRepository();
        }
        return lazySingleton;
    }



    public void addProduct(Product product){
        products.add(product);
    }

    public List<Product> findAll() {
        return products;
    }

}
