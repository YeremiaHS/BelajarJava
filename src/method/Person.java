package method;

public class Person {
    private String namaDepan;
    private String namaBelakang;
    private String domisili;
    int tahunLahir;
    //int umur = 2023 - tahunLahir;
    private String favProgLang;

    public void setNamaDepan(String fName) {
        namaDepan = fName;
    }

    public void setNamaBelakang(String lName) {
        namaBelakang = lName;
    }

    public String getFullName() {
        return namaDepan + " " + namaBelakang;
    }

    public void setDomisili(String Domisili) {
        domisili = Domisili;
    }

    public String getDomisili() {
        return domisili;
    }

    public void setTahunLahir(int TahunLahir) {
        tahunLahir = TahunLahir;
    }

    public int getUmur() {
        return 2023 - tahunLahir;
    }

    public void setProgLangFav(String favProg) {
        favProgLang = favProg;
    }

    public String getFavProgLang() {
        return favProgLang;
    }
}
