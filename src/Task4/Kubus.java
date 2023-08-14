package Task4;

public class Kubus extends Persegi implements BangunRuang{

    public Kubus(Double sisi) {
        super(sisi);
    }

    public Double getVolume() {
        return super.getLuas() * super.getSisi();
    }
    
}

    
