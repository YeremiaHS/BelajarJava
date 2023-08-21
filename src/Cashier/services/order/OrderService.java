package Cashier.services.order;


public interface OrderService {
    void createOrder(Integer idMenu, Integer jumlah);
    
    void getAllOrders();

    void updateOrder(Integer idOrder, Integer jumlah);
}
