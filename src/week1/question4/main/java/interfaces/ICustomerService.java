package interfaces;

import model.Customer;
import model.Order;

import java.util.List;

public interface ICustomerService {

    Customer addCustomer(String customerName, int customerAge);

    void addOrder(Customer customer, Order order);

    List<Customer> getAllCustomers();

    void printCustomerSize();

    void printCustomers();

}
