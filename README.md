# Lab-Sesion-1-PBO

Nama : Febrian Zaki Hidayatulloh   
Nim  : L0325045  
Tema : Sistem Perpustakaan  

Program Java ini merupakan aplikasi sederhana pengelolaan data buku perpustakaan dengan tema "Sistem Perpustakaan". Program menyimpan data beberapa buku ke dalam ArrayList, menampilkan data tersebut, memproses peminjaman buku, menghitung denda keterlambatan, mengolah string (judul buku), serta mendemonstrasikan penanganan error (exception handling). Program ini dibuat untuk memenuhi 9 kriteria tugas pemrograman Java dasar dengan menerapkan konsep Pemrograman Berorientasi Objek (OOP), dan terdiri dari 2 class dalam satu package `Labsesion`: `Buku.java` (model data) dan `SistemPerpustakaan.java` (program utama).

Alur Program
1. Inisialisasi Data — Program membuat ArrayList dan menambahkan 3 data buku (Pemrograman Java Dasar, Struktur Data, Algoritma dan Logika) sebagai objek dari class Buku.
2. Menampilkan Data — Program menggunakan looping for-each untuk menampilkan seluruh data buku satu per satu dengan method tampilkanInfo().
3. Proses Peminjaman — Program mengecek stok setiap buku menggunakan struktur if-else di dalam method pinjamBuku(); jika stok tersedia maka stok dikurangi, jika habis maka peminjaman gagal.
4. Mengolah String — Program mengubah judul buku menjadi huruf kapital (toUpperCase()) dan menghitung panjang judul (length()) saat menampilkan info buku.
5. Menghitung Denda — Program menghitung denda keterlambatan buku pertama berdasarkan selisih hari pinjam dengan batas maksimal pinjam (konstanta MAKS_HARI_PINJAM), dikalikan konstanta DENDA_PER_HARI.
6. Menangani Error — Program mendemonstrasikan exception handling menggunakan blok try-catch untuk menangkap ArithmeticException dari simulasi pembagian nol saat menghitung rata-rata denda.
7. Menentukan Grade — Program menghitung total stok tersisa dari seluruh buku, lalu menentukan grade ketersediaan (tipe data char: A/B/C/D) menggunakan struktur switch-case dan if-else.
8. Penutup — Program menampilkan total stok tersisa di perpustakaan beserta grade ketersediaan buku secara keseluruhan.

```
=== DAFTAR SEMUA BUKU ===
Kode   : B001
Judul  : PEMROGRAMAN JAVA DASAR (22 karakter)
Penulis: Andi Wijaya
Stok   : 3
Status : Tersedia
-------------------------
Kode   : B002
Judul  : STRUKTUR DATA (13 karakter)
Penulis: Budi Santoso
Stok   : 0
Status : Tersedia
-------------------------
Kode   : B003
Judul  : ALGORITMA DAN LOGIKA (20 karakter)
Penulis: Citra Dewi
Stok   : 5
Status : Tersedia
-------------------------

=== PROSES PEMINJAMAN ===
Pemrograman Java Dasar berhasil dipinjam. Sisa stok: 2
Struktur Data GAGAL dipinjam (stok habis).
Algoritma dan Logika berhasil dipinjam. Sisa stok: 4

=== HITUNG DENDA & SIMULASI ERROR ===
Denda Pemrograman Java Dasar (telat 3 hari): Rp6000.0
Rata-rata denda: Infinity

Total stok tersisa di perpustakaan: 6
Grade ketersediaan buku: B
```
