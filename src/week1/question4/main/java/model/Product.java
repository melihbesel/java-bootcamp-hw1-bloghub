package model;

public class Product {
    private static int counter = 1;
    private int productId;
    private int stockAmount;
    private double price;
    private String name;
    private String category;

    public Product(){
        setProductId(counter);
        counter++;
    }

    public Product(int stockAmount, double price, String name, String category) {
        setProductId(counter);
        this.stockAmount = stockAmount;
        this.price = price;
        this.name = name;
        this.category = category;
        counter++;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", stockAmount=" + stockAmount +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
