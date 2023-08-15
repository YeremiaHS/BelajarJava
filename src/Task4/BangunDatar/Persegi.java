package Task4.BangunDatar;

public class Persegi implements BangunDatar {

    //attribute
    private Double sisi;

    //constructor
    public Persegi(Double sisi) {
        if(sisi < 0) {
            throw new ArithmeticException("Please input a valid number");
        } else {
            this.sisi = sisi;
        }
    }
    
    public Persegi() {
    }

    //setter-getter
    public void setSisi(Double sisi) {
        if(sisi < 0) {
            throw new ArithmeticException("Please input a valid number");
        }  else {
            this.sisi = sisi;
        }
    }

    public Double getSisi(){
        return sisi;
    }

    //method custom
    @Override
    public void menggambarBangun() {
        System.out.println("=== PERSEGI ===");
    for (int i = 0; i < this.sisi; i++) {
      for (int j = 0; j < this.sisi; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
    }

    @Override
    public Double getKeliling() {
        return Double.valueOf(4 * this.getSisi());
    }

    @Override
    public Double getLuas() {
        return Double.valueOf(this.getSisi() * this.getSisi());
    }

    @Override
    public void karakteristikBangun() {
        System.out.println("=== Karakteristik ===");
        System.out.println("1. Memiliki 4 sisi sama panjang");
        System.out.println("2. Memiliki 4 sudut sama besar");
        System.out.println("3. Memiliki 2 diagonal sama panjang");
    }

    
}
