package service;

import interfaces.ICustomerService;
import model.Customer;
import model.Order;
import repository.CustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {

    private static final CustomerRepository customerRepository = CustomerRepository.getInstance();

    private static final CustomerService eagerSingleton = new CustomerService();

    private CustomerService(){
        System.out.println("CustomerService sınıfından bir nesne oluşturuldu.");
    }

    public static CustomerService getInstance(){
        return eagerSingleton;
    }



    public Customer addCustomer(String customerName, int customerAge){
        Customer customer = new Customer(customerName, customerAge);
        customerRepository.addCustomer(customer);
        return customer;
    }

    public void addOrder(Customer customer, Order order){
        customer.getOrders().add(order);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    /**
     * Prints total customer number in the system
     */
    public void printCustomerSize(){

        System.out.println("Total customer number: " + getAllCustomers().size());

    }

    public void printCustomers() {
        System.out.println("Customer list: ");
        customerRepository.findAll().forEach(a -> System.out.println(a));
    }

}
