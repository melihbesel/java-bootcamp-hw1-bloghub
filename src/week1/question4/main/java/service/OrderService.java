package service;

import model.Customer;
import model.Invoice;
import model.Order;
import model.Product;
import repository.InvoiceRepository;
import repository.OrderRepository;

import java.util.List;

public class OrderService {

    private static final OrderRepository orderRepository = OrderRepository.getInstance();

    private static final InvoiceService invoiceService = InvoiceService.getInstance();

    private static final OrderService eagerSingleton = new OrderService();

    private OrderService(){
        System.out.println("OrderService sınıfından bir nesne oluşturuldu.");
    }

    public static OrderService getInstance(){
        return eagerSingleton;
    }



    public void addOrder(Order order){
        orderRepository.addOrder(order);
    }

    public Order newOrder(List<Product> products){
        Order order = new Order();
        order.setProducts(products);
        Invoice invoice = new Invoice(order);
        invoice.setInvoiceAmount();
        order.setInvoice(invoice);
        addOrder(order);
        invoiceService.addInvoice(invoice);
        return order;
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public void printOrders() {
        System.out.println("Order list: ");
        orderRepository.findAll().forEach(a -> System.out.println(a));
    }

}
