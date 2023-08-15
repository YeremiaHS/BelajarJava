package Task4.BangunDatar;

//import Task4.BangunDatar;

public class Lingkaran implements BangunDatar {

    //attribute
    private Double jari;

    //constructor
    public Lingkaran(Double jari) {
        if(jari < 0) {
            throw new ArithmeticException("Please input valid number");
        } else {
            this.jari = jari;
        }
    }

    //setter-getter
    public void setJari(Double jari) {
        if(jari < 0) {
            throw new ArithmeticException("Please input valid number");
        } else {
            this.jari = jari;
        }
    }

    public Double getJari(){
        return jari;
    }

    //method custom
    @Override
    public void menggambarBangun() {
        System.out.println("=== Lingkaran ===");
    }

    @Override
    public Double getKeliling() {
        return Double.valueOf(3.14 * (this.getJari()* 2));
    }

    @Override
    public Double getLuas() {
        return Double.valueOf(3.14 * this.getJari()* this.getJari());
    }

    @Override
    public void karakteristikBangun() {
        System.out.println("=== Karakteristik ===");
        System.out.println("1. Memiliki diameter yang membagi 2 sisi seimbang");
        System.out.println("2. Memiliki jari-jari yang menghubungkan titik pusat dan busur");
    }
    
}
