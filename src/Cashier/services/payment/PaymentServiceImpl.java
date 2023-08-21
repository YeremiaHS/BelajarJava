package Cashier.services.payment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import Cashier.dao.OrderDao;
import Cashier.exception.BadRequestException;
import Cashier.models.Order;

public class PaymentServiceImpl implements PaymentService{

    OrderDao orderDao;

    public PaymentServiceImpl(OrderDao orderDao){
        this.orderDao = orderDao;
    }

    @Override
    public void getReceipt(Integer bayar) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMM uuuu HH:mm");
        LocalDateTime dateNow = LocalDateTime.now();
        String tanggal = dateNow.format(formatter).toString();
        System.out.println("====== BUKTI PEMBAYARAN ======");
        System.out.println("Tanggal: " + tanggal);
        System.out.println(" ");
        System.out.println("====== PESANAN ANDA =====");
        System.out.println(" ");
        List<Order> order = orderDao.findAll();
        Double totalHarga = 0.0;
        for (int i = 0; i < order.size(); i++){
            System.out.println((i + 1) + ". " + order.get(i));
            totalHarga += order.get(i).getTotal();
        }
        Double ppn = totalHarga * 0.11;
        Double hargaAkhir = totalHarga + ppn;
        if (bayar < hargaAkhir) {
            throw new BadRequestException("Uang Kurang");
        }
        System.out.println("Total harga: " + totalHarga);
        System.out.println("PPN: " + ppn);
        System.out.println("Harga setelah PPN: " + hargaAkhir);
        System.out.println("Uang Tunai: " + bayar);
        System.out.println("Kembalian: " + (bayar - hargaAkhir));
        System.out.println("Terima kasih atas pembeliannya");
    }
    
}
