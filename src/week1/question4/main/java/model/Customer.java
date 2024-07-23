package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static int counter = 1; //Default to 0
    private int customerId;
    private String customerName;
    private int customerAge;
    private List<Order> orders;

    public Customer(String customerName, int customerAge) {
        setCustomerId(counter);
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.orders = new ArrayList<>();
        counter++;
    }

    public Customer(String customerName, int customerAge, List<Order> orders) {
        setCustomerId(counter);
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.orders = orders;
        counter++;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAge=" + customerAge +
                ", orders=" + orders +
                '}';
    }
}
