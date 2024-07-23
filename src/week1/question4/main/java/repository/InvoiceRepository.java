package repository;

import model.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository {

    private List<Invoice> invoices = new ArrayList<>();

    private static InvoiceRepository lazySingleton;

    private InvoiceRepository(){
        System.out.println("InvoiceRepository sınıfından bir nesne oluşturuldu.");
    }

    public static InvoiceRepository getInstance(){
        if (lazySingleton == null){
            lazySingleton = new InvoiceRepository();
        }
        return lazySingleton;
    }



    public void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }

    public List<Invoice> findAll(){
        return invoices;
    }

}
