# Lab-Sesion-1-PBO

Nama : Febrian Zaki Hidayatulloh   
Nim  : L0325045  
Tema : Sistem Perpustakaan  

Program Java ini merupakan aplikasi sederhana pengelolaan data buku perpustakaan dengan tema "Sistem Perpustakaan". Program menyimpan data beberapa buku ke dalam ArrayList, menampilkan data tersebut, memproses peminjaman buku, menghitung denda keterlambatan, mengolah string (judul & kode buku), serta mendemonstrasikan penanganan error (exception handling) baik dari input pengguna maupun operasi aritmatika. Program ini dibuat untuk memenuhi 9 kriteria tugas pemrograman Java dasar dengan menerapkan konsep Pemrograman Berorientasi Objek (OOP), dan terdiri dari 2 class terpisah: `Buku.java` (model data) dan `SistemPerpustakaan.java` (program utama).   
Alur Program :  
1. Inisialisasi Data — Program membuat ArrayList dan menambahkan 3 data buku (Pemrograman Java Dasar, Struktur Data, Algoritma dan Logika) sebagai objek dari class Buku.
2. Menampilkan Data — Program menggunakan looping for-each untuk menampilkan seluruh data buku satu per satu dengan method tampilkanInfo().
3. Proses Peminjaman — Program mengecek stok setiap buku menggunakan struktur if-else di dalam method pinjamBuku(); jika stok tersedia maka stok dikurangi, jika habis maka peminjaman gagal.
4. Input Interaktif — Program meminta pengguna memasukkan kode buku yang ingin dipinjam, lalu mencocokkannya dengan data yang ada menggunakan method equalsIgnoreCase(). Program juga meminta input jumlah hari peminjaman untuk menghitung denda.
5. Mengolah String & Character — Program mengubah input kode buku menjadi huruf kapital (toUpperCase()) dan membersihkan spasi (trim()), mengambil panjang judul buku (length()), serta menentukan grade ketersediaan buku dalam bentuk tipe data char (A/B/C/D) berdasarkan total stok tersisa menggunakan switch-case.
6. Menangani Error — Program mendemonstrasikan exception handling untuk tiga skenario: kode buku yang tidak ditemukan (IllegalArgumentException), input yang bukan angka (InputMismatchException), dan simulasi pembagian nol saat menghitung rata-rata denda (ArithmeticException), semuanya ditangani dalam blok try-catch.
7. Penutup — Program menampilkan total stok tersisa di perpustakaan beserta grade ketersediaan buku secara keseluruhan.

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

=== PROSES PEMINJAMAN (INPUT USER) ===
Masukkan kode buku yang ingin dipinjam (contoh: B001): B001
Pemrograman Java Dasar berhasil dipinjam. Sisa stok: 2

=== HITUNG DENDA (INPUT USER) ===
Masukkan jumlah hari buku dipinjam: 10
Hari terlambat: 3
Total denda: Rp6000.0
Masukkan jumlah buku yang telat (untuk hitung rata-rata denda): 0
Terjadi kesalahan: Tidak bisa membagi dengan nol! (/ by zero)

Total stok tersisa di perpustakaan: 7
Grade ketersediaan buku: B
```
