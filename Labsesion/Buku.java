package Labsesion;

// ===== Poin 1: Class & Object (atribut + minimal 2 method) =====
public class Buku {
    // Atribut
    String kodeBuku;
    String judul;
    String penulis;
    int stok;
    boolean sedangDipinjam;

    // ===== Poin 2: Constructor =====
    public Buku(String kodeBuku, String judul, String penulis, int stok) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.stok = stok;
        this.sedangDipinjam = false;
    }

    // Method 1: menampilkan info buku
    public void tampilkanInfo() {
        // Poin 7: String method -> toUpperCase(), length()
        String judulUpper = judul.toUpperCase();
        System.out.println("Kode   : " + kodeBuku);
        System.out.println("Judul  : " + judulUpper + " (" + judul.length() + " karakter)");
        System.out.println("Penulis: " + penulis);
        System.out.println("Stok   : " + stok);
        System.out.println("Status : " + (sedangDipinjam ? "Sedang Dipinjam" : "Tersedia"));
    }

    // Method 2: proses peminjaman
    public boolean pinjamBuku() {
        // ===== Poin 4: Kondisional (if-else) =====
        if (stok > 0) {
            stok--;
            sedangDipinjam = true;
            return true;
        } else {
            return false;
        }
    }

    // Method 3: hitung denda berdasarkan hari terlambat
    public double hitungDenda(int hariTerlambat) {
        // ===== Poin 3: Konstanta (final) =====
        final double DENDA_PER_HARI = 2000.0;
        if (hariTerlambat <= 0) {
            return 0;
        }
        return hariTerlambat * DENDA_PER_HARI;
    }
}