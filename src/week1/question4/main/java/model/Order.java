package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int counter = 1;
    private int orderId;
    private List<Product> products;
    private Invoice invoice;

    public Order(){
        setOrderId(counter);
        this.products = new ArrayList<>();
        counter++;
    }

    public Order(List<Product> products) {
        setOrderId(counter);
        this.products = products;
        counter++;
    }

    public Order(List<Product> products, Invoice invoice) {
        setOrderId(counter);
        this.products = products;
        this.invoice = invoice;
        counter++;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", products=" + products +
                ", invoice=" + invoice +
                '}';
    }
}
