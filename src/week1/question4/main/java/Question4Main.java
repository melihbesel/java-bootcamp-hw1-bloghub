import factory.CustomerServiceFactory;
import factory.LoggerServiceFactory;
import interfaces.ICustomerService;
import interfaces.ILoggerService;
import model.Customer;
import model.Product;
import model.Order;

import service.CustomerService;
import service.ProductService;
import service.OrderService;
import service.InvoiceService;

import java.util.ArrayList;
import java.util.List;

public class Question4Main {

    public static void main(String[] args) {
        /**
         * Soru 3 - Singleton ve Factory pattern kullanarak projedeki objeleri oluşturun.
         */
        CustomerServiceFactory customerServiceFactory = new CustomerServiceFactory();
        ICustomerService customerService = customerServiceFactory.getICustomerService("CustomerService");
        ProductService productService = ProductService.getInstance();
        OrderService orderService = OrderService.getInstance();
        InvoiceService invoiceService = InvoiceService.getInstance();

        //Product object that will be stored
        Product product1 = productService.addProduct(5,600,"huawei p20","mobile phone");
        Product product2 = productService.addProduct(2,800,"samsung s3","mobile phone");
        Product product3 = productService.addProduct(3,400,"iphone 13","mobile phone");
        Product product4 = productService.addProduct(1,1200,"macbook air","laptop");
        Product product5 = productService.addProduct(7,40,"xiaomi redmi pro","mobile phone");

        //Order objects and adding products to the orders
        List<Product> productList1 = new ArrayList<>();
        productList1.add(product1);
        Order order1 = orderService.newOrder(productList1);
        //
        List<Product> productList2 = new ArrayList<>();
        productList2.add(product3);
        productList2.add(product4);
        Order order2 = orderService.newOrder(productList2);
        //
        List<Product> productList3 = new ArrayList<>();
        productList3.add(product1);
        productList3.add(product5);
        Order order3 = orderService.newOrder(productList3);
        //
        List<Product> productList4 = new ArrayList<>();
        productList4.add(product3);
        productList4.add(product5);
        productList4.add(product4);
        Order order4 = orderService.newOrder(productList4);
        //
        List<Product> productList5 = new ArrayList<>();
        productList5.add(product1);
        productList5.add(product2);
        productList5.add(product3);
        productList5.add(product5);
        Order order5 = orderService.newOrder(productList5);

        //Initializing Customers with some information and simulating that they have orders
        Customer customer1 = customerService.addCustomer("Melih", 29);
        Customer customer2 = customerService.addCustomer("Cem",28);
        Customer customer3 = customerService.addCustomer("Cem",22);
        Customer customer4 = customerService.addCustomer("Abraham",23);
        Customer customer5 = customerService.addCustomer("John",23);
        Customer customer6 = customerService.addCustomer("Camille",25);
        Customer customer7 = customerService.addCustomer("Viktor",18);
        Customer customer8 = customerService.addCustomer("Heimerdinger",19);
        Customer customer9 = customerService.addCustomer("Cem",27);
        Customer customer10 = customerService.addCustomer("Cem",28);
        Customer customer11 = customerService.addCustomer("Ahmet",38);

        customerService.addOrder(customer1, order1);
        customerService.addOrder(customer9, order3);
        customerService.addOrder(customer10, order4);

        System.out.println();
        /**
         * Prints total customer number in the system
         */
        customerService.printCustomerSize();

        System.out.println();
        /**
         * Prints total number of products bought by customers whose names are Cem
         */
        System.out.println("Total product number purchased by customers whose name is 'Cem' : " +
                productService.getProductNumberBoughtByCustomerName("cem"));

        System.out.println();
        /**
         * Prints total amount of invoices of customers whose names are 'Cem'
         * and their ages are between 25 and 30.
         */
        System.out.println("Total invoice amount (Name=\"Cem\" Age>25 Age<30): " +
                invoiceService.getTotalInvoiceByCustomerName("cem"));

        System.out.println();
        /**
         * Prints list of invoices that are greater than 1500 TL.
         */
        invoiceService.printInvoicesGreaterThan1500();

        System.out.println();
        /**
         * Prints all list.
         */
        productService.printProducts();
        orderService.printOrders();
        invoiceService.printInvoices();
        customerService.printCustomers();

    }
}
