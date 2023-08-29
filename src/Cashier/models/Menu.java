package Cashier.models;

// import java.util.ArrayList;
// import java.util.List;

public class Menu {
    private String menu;
    private Double harga;

    public Menu(){

    }

    public Menu(String menu, Double harga){
        this.menu = menu;
        this.harga = harga;
    }


    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return " " + menu + " | Rp " + harga + " ";
    }

    
}
