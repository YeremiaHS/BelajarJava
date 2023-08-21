package Cashier.services.menu;

import java.util.List;

import Cashier.models.Menu;

public interface MenuService {
    void createMenu(Menu menu);
    
    List<Menu> getAllMenu();

    Menu getMenuByID(Integer id);

    void setMakanan();

    void setPaket();

    void setMinuman();
}

