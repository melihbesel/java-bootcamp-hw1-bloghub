package model;

public class Invoice {
    private static int counter = 1; //Default to 0
    private int invoiceId;
    private double invoiceAmount;
    private Order order;

    public Invoice() {
        setInvoiceId(counter);
        counter++;
    }

    public Invoice(Order order) {
        setInvoiceId(counter);
        this.order = order;
        counter++;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setInvoiceAmount() {
        double amount = 0;

        for (int i = 0; i < order.getProducts().size(); i++) {
            amount += order.getProducts().get(i).getPrice();
        }
        invoiceAmount = amount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", invoiceAmount=" + invoiceAmount +
                ", orderId=" + order.getOrderId() +
                '}';
    }
}
