package service;

import interfaces.ICustomerService;
import model.Customer;
import model.Invoice;
import model.Order;
import repository.InvoiceRepository;

import java.util.ArrayList;
import java.util.List;

public class InvoiceService {

    private static final InvoiceRepository invoiceRepository = InvoiceRepository.getInstance();

    private static final ICustomerService customerService = CustomerService.getInstance();

    private static final InvoiceService eagerSingleton = new InvoiceService();

    private InvoiceService(){
        System.out.println("InvoiceService sınıfından bir nesne oluşturuldu.");
    }

    public static InvoiceService getInstance(){
        return eagerSingleton;
    }



    public void addInvoice(Invoice invoice){
        invoiceRepository.addInvoice(invoice);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    /**
     * Calculates total amount of invoices of customers whose names are 'Cem' and
     * their ages are between 25 and 30.
     * @return total amount of invoices
     */
    public double getTotalInvoiceByCustomerName(String customerName){
        double totalInvoice = 0;
        for (Customer customer : customerService.getAllCustomers()) {
            if (customer.getCustomerName().equalsIgnoreCase(customerName) && customer.getCustomerAge()>25 && customer.getCustomerAge()<30){
                for (int j = 0; j<customer.getOrders().size(); j++){
                    totalInvoice += customer.getOrders().get(j).getInvoice().getInvoiceAmount();
                }
            }
        }
        return totalInvoice;
    }

    /**
     * Prints list of invoices that are greater than 1500 TL.
     */
    public void printInvoicesGreaterThan1500(){
        System.out.println("Invoices list over 1500 TL: ");
        for (Invoice invoice: getInvoicesGreaterThan1500()){
            System.out.println(invoice);
        }
    }

    /**
     * Finds invoices that are greater than 1500 TL and store them in list.
     * @return list of invoices
     */
    public List<Invoice> getInvoicesGreaterThan1500(){
        List<Order> customerOrders = customerService.getAllCustomers().stream()
                .flatMap(c -> c.getOrders().stream()).toList();
        return customerOrders.stream().map(a -> a.getInvoice()).filter(b -> b.getInvoiceAmount() >= 1500).toList();
    }

    public void printInvoices() {
        System.out.println("Invoice list: ");
        invoiceRepository.findAll().forEach(a -> System.out.println(a));
    }

}
