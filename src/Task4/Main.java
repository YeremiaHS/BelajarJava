package Task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Pilih Bangun Untuk Dihitung ===");
        System.out.println("1. Persegi");
        System.out.println("2. Lingkaran");
        System.out.println("3. Persegi Panjang");
        System.out.println("4. Kubus");
        System.out.println("5. Balok");
        System.out.println("6. Tabung");
        System.out.println("=================================");
        System.out.println("Masukan pilihanmu: ");
        int select = Integer.valueOf(scanner.nextLine());

        switch(select) {
            case 1:
            System.out.println("Masukan Sisi: ");
            Double sisi = Double.valueOf(scanner.nextLine());

            Persegi persegi = new Persegi(sisi);
            persegi.menggambarBangun();
            System.out.println("Sisi: " + persegi.getSisi());
            System.out.println("Keliling: " + persegi.getKeliling());
            System.out.println("Luas: " + persegi.getLuas());
            break;

            case 2:
            System.out.println("Masukan jari-jari: ");
            Double jari = Double.valueOf(scanner.nextLine());

            Lingkaran lingkaran = new Lingkaran(jari);
            lingkaran.menggambarBangun();
            System.out.println("Jari-jari: " + lingkaran.getJari());
            System.out.println("Keliling: " + lingkaran.getKeliling());
            System.out.println("Luas: " + lingkaran.getLuas());
            break;

            case 3:
            System.out.println("Masukkan Panjang: ");
            Double panjang = Double.valueOf(scanner.nextLine());
            System.out.println("Masukkan Lebar: ");
            Double lebar = Double.valueOf(scanner.nextLine());

            PersegiPanjang perPanjang = new PersegiPanjang(panjang, lebar);
            perPanjang.menggambarBangun();
            System.out.println("Panjang: " + perPanjang.getPanjang());
            System.out.println("Lebar: " + perPanjang.getLebar());
            System.out.println("Keliling: " + perPanjang.getKeliling());
            System.out.println("Luas: " + perPanjang.getLuas());
            break;

            case 4:
            System.out.println("Masukan rusuk: ");
            Double rusuk = Double.valueOf(scanner.nextLine());

            Kubus kubus = new Kubus(rusuk);
            System.out.println("=== Kubus ===");
            System.out.println("Rusuk: " + rusuk);
            System.out.println("Volume: " + kubus.getVolume());
            break;

            case 5:
            System.out.println("Masukan Panjang: ");
            Double panjangBalok = Double.valueOf(scanner.nextLine());
            System.out.println("Masukan Lebar: ");
            Double lebarBalok = Double.valueOf(scanner.nextLine());
            System.out.println("Masukan Tinggi: ");
            Double tinggiBalok = Double.valueOf(scanner.nextLine());

            Balok balok = new Balok(panjangBalok, lebarBalok, tinggiBalok);
            System.out.println("=== Balok ===");
            System.out.println("Panjang: " + panjangBalok);
            System.out.println("Lebar: " + lebarBalok);
            System.out.println("Tinggi: " + tinggiBalok);
            System.out.println("Volume Balok: " + balok.getVolume());
            break;

            case 6:
            System.out.println("Masukan jari-jari: ");
            Double jariTabung = Double.valueOf(scanner.nextLine());
            System.out.println("Masukan tinggi: ");
            Double tinggiTabung = Double.valueOf(scanner.nextLine());

            Tabung tabung = new Tabung(jariTabung, tinggiTabung);
            System.out.println("Jari-jari: " + jariTabung);
            System.out.println("Tinggi: " + tinggiTabung);
            System.out.println("Volume tabung: " + tabung.getVolume());
        }
        scanner.close();
    }
}
