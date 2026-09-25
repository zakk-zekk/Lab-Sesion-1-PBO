package Labsesion;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SistemPerpustakaan {

    // ===== Poin 3: Konstanta tambahan (di level program) =====
    static final int MAKS_HARI_PINJAM = 7;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

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

        // ===== Poin 6: Exception Handling (input kode buku) =====
        System.out.println("\n=== PROSES PEMINJAMAN (INPUT USER) ===");
        System.out.print("Masukkan kode buku yang ingin dipinjam (contoh: B001): ");
        String kodeInput = input.nextLine().trim().toUpperCase(); // Poin 7: trim(), toUpperCase()

        Buku bukuDipilih = null;
        try {
            // Looping untuk mencari buku sesuai kode yang diinput
            for (Buku b : daftarBuku) {
                // Poin 7: String method -> equalsIgnoreCase()
                if (b.kodeBuku.equalsIgnoreCase(kodeInput)) {
                    bukuDipilih = b;
                    break;
                }
            }

            if (bukuDipilih == null) {
                // Kondisional: kode tidak ditemukan -> lempar exception sendiri
                throw new IllegalArgumentException("Kode buku '" + kodeInput + "' tidak ditemukan.");
            }

            boolean berhasil = bukuDipilih.pinjamBuku();
            if (berhasil) {
                System.out.println(bukuDipilih.judul + " berhasil dipinjam. Sisa stok: " + bukuDipilih.stok);
            } else {
                System.out.println(bukuDipilih.judul + " GAGAL dipinjam (stok habis).");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }

        // ===== Poin 6: Exception Handling (input hari telat + pembagian oleh nol) =====
        System.out.println("\n=== HITUNG DENDA (INPUT USER) ===");
        try {
            System.out.print("Masukkan jumlah hari buku dipinjam: ");
            int totalHariPinjam = input.nextInt(); // bisa lempar InputMismatchException jika bukan angka

            int sisaHari = totalHariPinjam - MAKS_HARI_PINJAM;
            double denda = (bukuDipilih != null)
                    ? bukuDipilih.hitungDenda(sisaHari)
                    : buku1.hitungDenda(sisaHari);

            System.out.println("Hari terlambat: " + Math.max(sisaHari, 0));
            System.out.println("Total denda: Rp" + denda);

            System.out.print("Masukkan jumlah buku yang telat (untuk hitung rata-rata denda): ");
            int jumlahBukuTelat = input.nextInt();

            // Simulasi error pembagian oleh nol jika user memasukkan 0
            int totalDenda = (int) denda;
            int rataDenda = totalDenda / jumlahBukuTelat;
            System.out.println("Rata-rata denda per buku: Rp" + rataDenda);

        } catch (InputMismatchException e) {
            System.out.println("Terjadi kesalahan: Input harus berupa angka!");
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

        input.close();
    }
}