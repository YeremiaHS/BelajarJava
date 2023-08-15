package Task4.BangunRuang;

import Task4.BangunDatar.Lingkaran;

public class Tabung extends Lingkaran implements BangunRuang{

    public Tabung(Double jari, Double tinggi) {
        super(jari);
        this.tinggi = tinggi;
        //TODO Auto-generated constructor stub
    }

    private Double tinggi;

    public void setTinggi(Double tinggi){
        if(tinggi < 0){
            throw new ArithmeticException("Please input a valid number");
        } else {
            this.tinggi = tinggi;
        }
    }

    public double getTinggi(){
        return tinggi;
    }

    @Override
    public Double getVolume() {
        return super.getLuas() * this.getTinggi();
    }
    
}
