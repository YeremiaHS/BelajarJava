package Task4;

public class Persegi implements BangunDatar {

    //attributr
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

    
}
