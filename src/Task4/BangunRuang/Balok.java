package Task4.BangunRuang;

//import Task4.BangunRuang;
import Task4.BangunDatar.PersegiPanjang;

public class Balok extends PersegiPanjang implements BangunRuang {

    public Balok(Double panjang, Double lebar, Double tinggi) {
        super(panjang, lebar);
        this.tinggi = tinggi;
        //TODO Auto-generated constructor stub
    }

    private Double tinggi;

    public void setTinggi(Double tinggi){
        if(tinggi < 0) {
            throw new ArithmeticException("Please input a valid number");
        } else {
            this.tinggi = tinggi;
        }
    }

    public Double getTinggi(){
        return tinggi;
    }

    @Override
    public Double getVolume() {
        return super.getLuas() * this.getTinggi();
    }
    
}
