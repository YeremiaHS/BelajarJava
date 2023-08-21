package Cashier.dao;

import java.util.ArrayList;
import java.util.List;

import Cashier.models.Order;
import Cashier.services.BaseDao;

public class OrderDao implements BaseDao<Order, Integer> {

    List<Order> order = new ArrayList<>();

    @Override
    public void save(Order data) {
        order.add(data);
    }

    @Override
    public List<Order> findAll() {
        return this.order;
    }

    @Override
    public Order findById(Integer id) {
        return this.order.get(id - 1);
    }

    @Override
    public void update(Integer id, Order data) {
        order.set(id -1, data);
    }

    @Override
    public void delete(Integer id) {
        order.remove(id -1);
    }
    
}
