package Labsesion;

import java.util.ArrayList;

public class SistemPerpustakaan {
    // ===== Poin 3: Konstanta tambahan (di level program) =====
    static final int MAKS_HARI_PINJAM = 7;

    public static void main(String[] args) {

        // ===== Poin 8: Array atau Collection (pakai ArrayList) =====
        ArrayList<Buku> daftarBuku = new ArrayList<>();

        // ===== Poin 9: Membuat object dari class Buku =====
        Buku buku1 = new Buku("B001", "Pemrograman Java Dasar", "Andi Wijaya", 3);
        Buku buku2 = new Buku("B002", "Struktur Data", "Budi Santoso", 0);
        Buku buku3 = new Buku("B003", "Algoritma dan Logika", "Citra Dewi", 5);

        daftarBuku.add(buku1);
        daftarBuku.add(buku2);
        daftarBuku.add(buku3);

        System.out.println("=== DAFTAR SEMUA BUKU ===");
        // ===== Poin 5: Looping (for-each) untuk memproses data berulang =====
        for (Buku b : daftarBuku) {
            b.tampilkanInfo();
            System.out.println("-------------------------");
        }

        System.out.println("\n=== PROSES PEMINJAMAN ===");
        // Looping menggunakan for biasa (index) untuk cek & proses peminjaman
        for (int i = 0; i < daftarBuku.size(); i++) {
            Buku b = daftarBuku.get(i);
            boolean berhasil = b.pinjamBuku();

            // Kondisional if-else untuk menentukan pesan
            if (berhasil) {
                System.out.println(b.judul + " berhasil dipinjam. Sisa stok: " + b.stok);
            } else {
                System.out.println(b.judul + " GAGAL dipinjam (stok habis).");
            }
        }

        // ===== Poin 6: Exception Handling =====
        System.out.println("\n=== HITUNG DENDA & SIMULASI ERROR ===");
        try {
            // Simulasi input hari pinjam dari user (misal salah input jadi 0 -> pembagian oleh nol)
            int totalHariPinjam = 10;
            int sisaHari = totalHariPinjam - MAKS_HARI_PINJAM; // 3 hari telat
            double denda = buku1.hitungDenda(sisaHari);
            System.out.println("Denda " + buku1.judul + " (telat " + sisaHari + " hari): Rp" + denda);

            // Simulasi error: pembagian oleh nol saat hitung rata-rata denda per buku
            int jumlahBukuTelat = 0; // sengaja 0 untuk memicu error
            double rataDenda = denda / jumlahBukuTelat;
            System.out.println("Rata-rata denda: " + rataDenda);

        } catch (ArithmeticException e) {
            System.out.println("Terjadi kesalahan: Tidak bisa membagi dengan nol! (" + e.getMessage() + ")");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan tak terduga: " + e.getMessage());
        }

        // ===== Poin 7: Penggunaan tipe data char =====
        char gradeStatus;
        int totalStokTersisa = 0;
        for (Buku b : daftarBuku) {
            totalStokTersisa += b.stok;
        }

        // Kondisional switch-case berdasarkan total stok tersisa
        switch (totalStokTersisa) {
            case 0:
                gradeStatus = 'D'; // stok kosong semua
                break;
            default:
                if (totalStokTersisa <= 3) {
                    gradeStatus = 'C';
                } else if (totalStokTersisa <= 7) {
                    gradeStatus = 'B';
                } else {
                    gradeStatus = 'A';
                }
        }

        System.out.println("\nTotal stok tersisa di perpustakaan: " + totalStokTersisa);
        System.out.println("Grade ketersediaan buku: " + gradeStatus);
    }
}