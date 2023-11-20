import java.util.LinkedList;
import java.util.Scanner;

// Eleman sınıfı
class Eleman {
    String adSoyad;
    String dogumTarihi;
    String telefonNumarasi;

    public Eleman(String adSoyad, String dogumTarihi, String telefonNumarasi) {
        this.adSoyad = adSoyad;
        this.dogumTarihi = dogumTarihi;
        this.telefonNumarasi = telefonNumarasi;
    }
}

// KuyrukLinkedList sınıfı
class KuyrukLinkedList {
    private LinkedList<Eleman> kuyrukListesi = new LinkedList<>();

    // Kuyruğa eleman ekleme
    public void kuyrugaEkle(Eleman eleman) {
        kuyrukListesi.addLast(eleman);
        System.out.println(eleman.adSoyad + " kuyruğa eklendi.");
    }

    // Kuyruktan eleman çekme
    public void kuyruktanCek() {
        if (!kuyrukListesi.isEmpty()) {
            Eleman cekilenEleman = kuyrukListesi.removeFirst();
            System.out.println(cekilenEleman.adSoyad + " kuyruktan çekildi.");
        } else {
            System.out.println("Kuyruk boş. Eleman çekilemiyor.");
        }
    }

    // Kuyruktaki tüm elemanları listeleme
    public void kuyruktakiElemanlariListele() {
        if (!kuyrukListesi.isEmpty()) {
            System.out.println("Kuyruktaki Elemanlar:");
            for (Eleman eleman : kuyrukListesi) {
                System.out.println("Ad Soyad: " + eleman.adSoyad +
                                   ", Doğum Tarihi: " + eleman.dogumTarihi +
                                   ", Telefon Numarası: " + eleman.telefonNumarasi);
            }
        } else {
            System.out.println("Kuyruk boş.");
        }
    }

    // Kuyruk eleman sayısını getirme
    public int kuyrukElemanSayisi() {
        return kuyrukListesi.size();
    }

    // Kuyrukta arama yapma
    public void kuyruktaAra(String arananAdSoyad) {
        for (Eleman eleman : kuyrukListesi) {
            if (eleman.adSoyad.equalsIgnoreCase(arananAdSoyad)) {
                System.out.println("Aranan eleman bulundu: " + eleman.adSoyad);
                return;
            }
        }
        System.out.println("Aranan eleman bulunamadı.");
    }
}

// AnaSinif sınıfı
public class Data {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KuyrukLinkedList kuyruk = new KuyrukLinkedList();

        while (true) {
            System.out.println("1. Kuyruğa Eleman Ekle");
            System.out.println("2. Kuyruktan Eleman Çek");
            System.out.println("3. Kuyruktaki Elemanları Listele");
            System.out.println("4. Kuyruk Eleman Sayısı");
            System.out.println("5. Kuyrukta Ara");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminizi yapın: ");

            int secim = scanner.nextInt();
            scanner.nextLine(); // Dummy nextLine() çağrısı

            switch (secim) {
                case 1:
                    System.out.print("Ad Soyad: ");
                    String adSoyad = scanner.nextLine();
                    System.out.print("Doğum Tarihi: ");
                    String dogumTarihi = scanner.nextLine();
                    System.out.print("Telefon Numarası: ");
                    String telefonNumarasi = scanner.nextLine();

                    Eleman yeniEleman = new Eleman(adSoyad, dogumTarihi, telefonNumarasi);
                    kuyruk.kuyrugaEkle(yeniEleman);
                    break;
                case 2:
                    kuyruk.kuyruktanCek();
                    break;
                case 3:
                    kuyruk.kuyruktakiElemanlariListele();
                    break;
                case 4:
                    System.out.println("Kuyruk Eleman Sayısı: " + kuyruk.kuyrukElemanSayisi());
                    break;
                case 5:
                    System.out.print("Aranan Ad Soyad: ");
                    String arananAdSoyad = scanner.nextLine();
                    kuyruk.kuyruktaAra(arananAdSoyad);
                    break;
                case 6:
                    System.out.println("Programdan çıkılıyor.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Geçersiz seçim. Tekrar deneyin.");
                    break;
            }
        }
    }
}