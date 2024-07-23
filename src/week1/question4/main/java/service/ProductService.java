package service;

import interfaces.ICustomerService;
import model.Customer;
import model.Order;
import model.Product;
import repository.ProductRepository;

import java.util.List;

public class ProductService {

    private static final ProductRepository productRepository = ProductRepository.getInstance();

    private static final ICustomerService customerService = CustomerService.getInstance();

    private static final ProductService eagerSingleton = new ProductService();

    private ProductService(){
        System.out.println("ProductService sınıfından bir nesne oluşturuldu.");
    }

    public static ProductService getInstance(){
        return eagerSingleton;
    }



    public Product addProduct(int stockAmount, double price, String name, String category){
        Product product = new Product(stockAmount, price, name, category);
        productRepository.addProduct(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Calculates the total number of products that customers whose names are 'Cem' bought
     * @return total number of products
     */
    public int getProductNumberBoughtByCustomerName(String customerName){
        int total = 0;
        for (Customer customer : customerService.getAllCustomers()) {
            if (customer.getCustomerName().equalsIgnoreCase(customerName)){
                for (Order order: customer.getOrders()){
                    total+=order.getProducts().size();
                }
            }
        }
        return total;
    }

    public void printProducts() {
        System.out.println("Product list: ");
        productRepository.findAll().forEach(a -> System.out.println(a));
    }

}

