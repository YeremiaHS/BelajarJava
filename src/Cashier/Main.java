package Cashier;

import java.util.List;
import java.util.Scanner;

import Cashier.dao.MenuDao;
import Cashier.dao.OrderDao;
import Cashier.models.Menu;
import Cashier.services.menu.MenuService;
import Cashier.services.menu.MenuServiceImpl;
import Cashier.services.order.OrderService;
import Cashier.services.order.OrderServiceImpl;
import Cashier.services.payment.PaymentService;
import Cashier.services.payment.PaymentServiceImpl;

public class Main {
    static OrderDao orderDao = new OrderDao();

    static MenuDao menuDao = new MenuDao();

    static MenuService menuService = new MenuServiceImpl(menuDao);

    static OrderService orderService = new OrderServiceImpl(menuDao, orderDao);

    static PaymentService paymentService = new PaymentServiceImpl(orderDao);

    private static void mainMenu(){
        System.out.println("""
                ====== WARTEG ABADI ======

                1. Lihat Daftar Menu
                2. Input Pemesanan
                3. Pembayaran
                """);
                System.out.println("* Masukan pilihan: ");
    }

    private static List<Menu> listMenu(){
        System.out.println("====== Daftar Menu ======");
        System.out.println(" ");
        List<Menu> menuMakanan = menuService.getAllMenu();
        for (int i = 0; i < menuMakanan.size(); i++){
            System.out.println((i + 1) + ". " + menuMakanan.get(i));
        }
        System.out.println(" ");
        return menuMakanan;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean ulang = true;
        int pilih;
        menuService.setMakanan();
        menuService.setMinuman();
        menuService.setPaket();

        try{
            while (ulang) {
                mainMenu();
                pilih = Integer.valueOf(scanner.nextLine());
                switch(pilih){
                    case 1:
                    listMenu();
                    break;

                    case 2:
                    listMenu();
                        while (true) {
                        System.out.println("* Ingin Menambah / Mengubah Pesanan ? (Tambah | Ubah | Kembali) ");
                        String again = scanner.nextLine();
                        if("Kembali".equalsIgnoreCase(again)) {
                                break;
                            } else if("Tambah".equalsIgnoreCase(again)){
                                try {
                                    System.out.println("* Silakan input nomor makanan yang ingin dipesan: ");
                                    int pilihMenu = Integer.valueOf(scanner.nextLine());
                                    System.out.println("* Jumlah menu yang ingin dipesan: ");
                                    int pilihJumlah = Integer.valueOf(scanner.nextLine());
                                    orderService.createOrder(pilihMenu, pilihJumlah);
                                    System.out.println(" ");
                                    System.out.println("====== PESANAN ANDA =====");
                                    orderService.getAllOrders();
                                    break;
                                } catch (Exception BadRequestException) {
                                    System.out.println(" ");
                                    System.out.println("Masukkan Valid ID");
                                    System.out.println(" ");
                                    continue;
                                } 
                            } else if ("Ubah".equalsIgnoreCase(again)) {
                                try {
                                    System.out.println("* Masukan nomor order yang ingin dirubah: ");
                                    int pilihUbah = Integer.valueOf(scanner.nextLine());
                                    System.out.println("* Masukan jumlah baru: ");
                                    int ubahJumlah = Integer.valueOf(scanner.nextLine());
                                    orderService.updateOrder(pilihUbah, ubahJumlah);
                                    System.out.println("");
                                    System.out.println("====== PESANAN ANDA =====");
                                    orderService.getAllOrders();
                                    break;
                                } catch (Exception BadRequestException) {
                                    System.out.println(" ");
                                    System.out.println("Masukkan Valid ID");
                                    System.out.println(" ");
                                    continue;
                                }
                            } else if ("kembali".equalsIgnoreCase(again)) {
                                break;
                            }
                                System.out.println("Pilihan tak tersedia!");
                        }
                    break;

                    case 3:
                    try {
                        System.out.println(" ");
                        System.out.println("====== PESANANMU ====");
                        orderService.getAllOrders();
                        System.out.println("Cash: ");
                        Integer bayar = Integer.valueOf(scanner.nextLine());
                        paymentService.getReceipt(bayar);
                        break;
                    } catch (Exception BadRequestException) {
                        System.out.println(" ");
                        System.out.println("Uang anda kurang!");
                        System.out.println(" ");
                        continue;
                    }
                      
                }
                while (true) {
                    System.out.println(" ");
                    System.out.println("* Lanjut ke Pemesanan / Pembayaran ? (Y | N) ");
                    String again = scanner.nextLine();
                    if("Y".equalsIgnoreCase(again)) {
                        break;
                    } else if("N".equalsIgnoreCase(again)){
                        ulang = false;
                        break;
                    } else {
                        System.out.println("Input invalid!");
                        continue;
                    }
                }
            }
        } finally{
            scanner.close();
        }
    }

}