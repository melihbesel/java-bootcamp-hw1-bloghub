package repository;

import model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private List<Order> orders = new ArrayList<>();

    private static OrderRepository lazySingleton;

    private OrderRepository(){
        System.out.println("OrderRepository sınıfından bir nesne oluşturuldu.");
    }

    public static OrderRepository getInstance(){
        if (lazySingleton == null){
            lazySingleton = new OrderRepository();
        }
        return lazySingleton;
    }



    public void addOrder(Order order){
        orders.add(order);
    }

    public List<Order> findAll(){
        return orders;
    }

}
