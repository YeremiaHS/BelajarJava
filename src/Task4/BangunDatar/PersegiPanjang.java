package Task4.BangunDatar;

public class PersegiPanjang implements BangunDatar{

    //attribute
    private Double panjang;
    private Double lebar;

    //constructor
    public PersegiPanjang(Double panjang, Double lebar) {
        if(panjang < 0){
            throw new ArithmeticException("Please input a valid number");
        } if (lebar < 0) {
            throw new ArithmeticException("Please input a valid number");
        } else {
            this.lebar = lebar;
            this.panjang = panjang;
        }
    }

    //setter-getter
    public void setPanjang(Double panjang) {
        if (panjang < 0) {
            throw new ArithmeticException("Please input a valid number");
        } else {
            this.panjang = panjang;
        }
    }
    
    public Double getPanjang(){
        return panjang;
    }

    public void setLebar(Double lebar) {
        if (lebar < 0) {
            throw new ArithmeticException("Please input a valid number");
        } else {
            this.lebar = lebar;
        }
    }

    public Double getLebar(){
        return lebar;
    }

    //method custom
    @Override
    public void menggambarBangun() {
        System.out.println("=== PERSEGI ===");
        for (int i = 0; i < this.lebar; i++) {
            for (int j = 0; j < this.panjang; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    @Override
    public Double getKeliling() {
        return Double.valueOf((2 * this.panjang) + (2 * this.lebar));
    }

    @Override
    public Double getLuas() {
        return Double.valueOf(this.panjang * this.lebar);
    }

    @Override
    public void karakteristikBangun() {
        System.out.println("=== Karakteristik ===");
        System.out.println("1. Memiliki 4 sudut siku-siku yang sama besar");
        System.out.println("2. Memiliki 4 sisi dimana 2 sisi berhadapan sama panjang");
    }
    
}
