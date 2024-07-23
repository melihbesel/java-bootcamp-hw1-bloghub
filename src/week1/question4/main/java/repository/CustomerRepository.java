package repository;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private List<Customer> customers = new ArrayList<>();

    private static CustomerRepository lazySingleton;

    private CustomerRepository(){
        System.out.println("CustomerRepository sınıfından bir nesne oluşturuldu.");
    }

    public static CustomerRepository getInstance(){
        if (lazySingleton == null){
            lazySingleton = new CustomerRepository();
        }
        return lazySingleton;
    }



    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public List<Customer> findAll() {
        return customers;
    }

}
