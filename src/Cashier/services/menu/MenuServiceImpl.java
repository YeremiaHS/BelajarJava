package Cashier.services.menu;

import java.util.List;

import Cashier.dao.MenuDao;
import Cashier.models.Menu;

public class MenuServiceImpl implements MenuService{

    MenuDao menuDao;

    public MenuServiceImpl(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Override
    public void createMenu(Menu menu) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createMenu'");
    }

    @Override
    public List<Menu> getAllMenu() {
        return menuDao.findAll();
    }

    @Override
    public Menu getMenuByID(Integer id) {
        return menuDao.findById(id);
    }

    @Override
    public void setMakanan() {
        menuDao.save(new Menu("Nasi putih ", 4500.0));
        menuDao.save(new Menu("Ayam Goreng ", 12000.0));
        menuDao.save(new Menu("Ayam Bakar ", 14000.0));
        menuDao.save(new Menu("Tahu ", 1000.0));
        menuDao.save(new Menu("Tempe ", 1000.0));
        menuDao.save(new Menu("Bakwan ", 1500.0));
        menuDao.save(new Menu("Sate Usus ", 3500.0));
    }

    @Override
    public void setPaket() {
        menuDao.save(new Menu("Es Teh Manis ", 3000.0));
        menuDao.save(new Menu("Teh Hangat Manis ", 2500.0));
        menuDao.save(new Menu("Air Mineral ", 2000.0));
        menuDao.save(new Menu("Kopi Hitam ", 3000.0));
    }

    @Override
    public void setMinuman() {
        menuDao.save(new Menu("Paket A: Ayam Goreng + Nasi Putih + Es Teh Manis ", 18000.0));
        menuDao.save(new Menu("Paket B: Ayam Bakar + Nasi Putih + Es Teh Manis + Sate Usus ", 23500.0));
        menuDao.save(new Menu("Paket C: Nasi Putih + Tahu + Tempe + Air Mineral ", 7500.0));
    }
    
}
