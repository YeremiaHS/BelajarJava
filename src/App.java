import java.util.Scanner;
import method.Person;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nama Depan: ");
        String namaDepan = scanner.nextLine();
        System.out.println("Nama Belakang: ");
        String namaBelakang = scanner.nextLine();
        System.out.println("Domsisili: ");
        String domisili = scanner.nextLine();
        System.out.println("Tahun Lahir: ");
        int tahunLahir = Integer.valueOf(scanner.nextLine());
        System.out.println("Bahasa Pemrograman Favorit: ");
        String favProgLang = scanner.nextLine();

        Person person = new Person();
        person.setNamaDepan(namaDepan);
        person.setNamaBelakang(namaBelakang);
        person.setDomisili(domisili);
        person.setTahunLahir(tahunLahir);
        person.setProgLangFav(favProgLang);

        System.out.println("==== Data Dirimu ====");
        System.out.println("Nama Lengkap: " + person.getFullName());
        System.out.println("Domisili: " + person.getDomisili());
        System.out.println("Umur: " + person.getUmur());
        System.out.println("Bahasa Pemrograman Favorit: " + person.getFavProgLang());

        scanner.close();
    }
}
