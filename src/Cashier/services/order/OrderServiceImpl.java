package Cashier.services.order;

import java.util.List;

import Cashier.models.Menu;
import Cashier.models.Order;
import Cashier.dao.MenuDao;
import Cashier.dao.OrderDao;
import Cashier.exception.BadRequestException;

public class OrderServiceImpl implements OrderService{
    MenuDao menuDao;
    OrderDao orderDao;

    public OrderServiceImpl(MenuDao menuDao, OrderDao orderDao){
        this.menuDao = menuDao;
        this.orderDao = orderDao;
    }

    @Override
    public void createOrder(Integer idMenu, Integer jumlah) {
        if (idMenu <= 0 || idMenu > menuDao.findAll().size()) {
            throw new BadRequestException("Input Valid Menu");
        } else if (jumlah <= 0) {
            throw new BadRequestException("Input Valid Number");
        }
        Menu menu = menuDao.findById(idMenu);
        Double harga = menu.getHarga();
        Double total = harga * jumlah;
        Order order = new Order(menu, jumlah, harga, total);
        orderDao.save(order);
        System.out.println("Input berhasil");
    }

    @Override
    public void getAllOrders() {
        List<Order> order = orderDao.findAll();
        Double totalHarga = 0.0;
        for (int i = 0; i < order.size(); i++){
            System.out.println((i + 1) + ". " + order.get(i));
            totalHarga += order.get(i).getTotal();
        }
        Double ppn = totalHarga * 0.11;
        Double hargaAkhir = totalHarga + ppn;
        System.out.println(" ");
        System.out.println("Total harga: Rp " + totalHarga);
        System.out.println("PPN: Rp " + ppn);
        System.out.println("Harga setelah PPN: Rp " + hargaAkhir);
    }

    @Override
    public void updateOrder(Integer idOrder, Integer jumlahUpdate) {
        if (idOrder <= 0 || idOrder > orderDao.findAll().size()) {
            throw new BadRequestException("Input Valid Menu");
        } else if (jumlahUpdate <= 0) {
            throw new BadRequestException("Input Valid Number");
        }
        Order menuUpdate = orderDao.findById(idOrder);
        menuUpdate.setJumlah(jumlahUpdate);
        menuUpdate.setTotal(jumlahUpdate * menuUpdate.getHarga());
        orderDao.update(idOrder, menuUpdate);
        System.out.println("Update Berhasil!");
    }
    
}
