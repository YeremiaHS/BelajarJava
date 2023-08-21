package Cashier.dao;

import java.util.ArrayList;
import java.util.List;

import Cashier.models.Menu;
import Cashier.services.BaseDao;

public class MenuDao implements BaseDao<Menu, Integer> {

    List<Menu> menu = new ArrayList<>();

    @Override
    public List<Menu> findAll() {
        return this.menu;
    }

    @Override
    public Menu findById(Integer id) {
        return this.menu.get(id - 1);
    }

    @Override
    public void update(Integer id, Menu data) {
        menu.set(id, data);
    }

    @Override
    public void delete(Integer id) {
        menu.remove(id - 1);
    }

    @Override
    public void save(Menu data) {
        menu.add(data);
    }
    
}
