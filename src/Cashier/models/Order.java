package Cashier.models;

public class Order {
    private Menu menu;
    private Integer jumlah;
    private Double harga;
    private Double total;

    public Order(){

    }

    public Order(Menu menu, Integer jumlah, Double harga, Double total){
        this.menu = menu;
        this.jumlah = jumlah;
        this.harga = harga;
        this.total = total;
    }
    
    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "[" + menu + "] Jumlah: " + jumlah + " x " + harga + " = " + total + " ";
    }

}
