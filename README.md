# Character Manager — TP3

**Mata Kuliah:** Java Visual  
**Kelas:** SIH-6406

## Deskripsi Program

Character Manager adalah program sederhana berbasis Java yang digunakan untuk mengelola karakter dalam permainan RPG (*Role-Playing Game*).

## Fitur Program

- **Level Up:** Meningkatkan level karakter.
- **Mana:** Mengelola nilai mana karakter.
- **Status Hidup:** Memeriksa apakah karakter masih hidup menggunakan method `isAlive()`.

## Screenshot Output

![Screenshot Output](outputtp3.png)

---

## Fitur Program TP5 (Terbaru)

- **Manajemen & Analisis (Bagian A & B):** Mencegah duplikat nama karakter menggunakan `equals()`, menghitung rata-rata level (`getAverageLevel()`), mencari karakter berdasarkan tipe (`findByType()`) dan level tertinggi (`getHighestLevelCharacter()`).
- **Fitur Analitik Tambahan (Bagian C):** Menghitung total karakter berdasarkan tipe tertentu (`countByType()`).

## Screenshot Output TP5

![Screenshot Output TP5](outputtp5.png)

---

### Fitur Program TP8 

- **Implementasi GUI (Bagian A):** Antarmuka pengguna berbasis Java Swing menggunakan `MainWindow` dan `SwingUtilities.invokeLater()`.
- **Manajemen & Tampilan Dinamis (Bagian B):** Menambahkan minimal 5 karakter secara dinamis serta menampilkan perhitungan rata-rata level secara otomatis pada GUI.

## Screenshot Output TP8

1. Screenshot MainWindow (Minimal 5 Karakter + Statistik)
![Screenshot Sebelum](outputtp8_sebelum.png)
![Screenshot Sesudah](outputtp8_sesudah.png)

2. Penjelasan Aliran Data MVC (3-4 Kalimat)
Aliran data dimulai dari kelas `Main` yang berfungsi menginisialisasi objek `CharacterManager` serta memasukkan data karakter awal. Objek `CharacterManager` bertindak sebagai Model yang menyimpan dan mengelola kumpulan data karakter secara terpusat. Data tersebut kemudian dikirimkan ke kelas `MainWindow` yang berperan sebagai View melalui constructor untuk dirender ke antarmuka pengguna, termasuk menampilkan perhitungan statistik rata-rata level. Penerapan pola MVC ini memisahkan secara tegas antara logika pengelolaan data dengan tampilan visual aplikasi.

3. Daftar Karakter Baru & Alasan Pemilihan
* **Arthas (KNIGHT, Level 5)**: Dipilih untuk merepresentasikan peran petarung garis depan (*tank*) dengan tingkat level menengah yang stabil guna menjaga keseimbangan statistik rata-rata.
* **Jaina (SUMMONER, Level 4)**: Dipilih guna memberikan variasi kelas karakter pengguna sihir pemanggil dengan level penyeimbang di bawah ksatria.
* **Thrall (NECROMANCER, Level 3)**: Dipilih untuk menghadirkan variasi kelas magis kegelapan dengan tingkat level yang lebih rendah agar rentang data lebih bervariasi.
* **Sylvanas (ASSASSIN, Level 6)**: Dipilih sebagai representasi kelas penyerang cepat dengan level tertinggi untuk menguji fungsionalitas pencarian data level maksimum.
* **Uther (KNIGHT, Level 5)**: Dipilih sebagai ksatria tambahan untuk menguji keakuratan metode penghitungan jumlah karakter berdasarkan tipe yang sama (`countByType`).

---

### Fitur Program TP10

* **Theming (Bagian A):** Menggunakan `AppTheme.java` untuk mengatur warna, font, dan border agar tampilan aplikasi lebih konsisten. Kartu karakter memiliki warna berbeda sesuai role masing-masing.
* **Mini-Challenge (Bagian B):** Karakter dengan level minimal 5 ditampilkan menggunakan teks berwarna emas dan tebal. Batas level disimpan dalam konstanta bernama `GOLD_LEVEL_THRESHOLD`.
* **Properti Tambahan:**

  1. **Tooltip:** Menampilkan informasi nama, role, dan level karakter ketika kursor diarahkan ke kartu.
  2. **Border Berdasarkan Role:** Setiap kartu memiliki warna border sesuai role karakter agar lebih mudah dibedakan.

### Alasan Penggunaan AppTheme

Warna disimpan di `AppTheme` karena pengaturan warna merupakan bagian dari tampilan aplikasi (View). Dengan demikian, seluruh komponen dapat menggunakan tema yang sama secara konsisten. Jika warna ingin diubah, cukup dilakukan melalui `AppTheme` tanpa mengubah kelas `Character`. Kelas `Character` tetap berfokus pada pengelolaan data dan atribut karakter.

### Screenshot Output TP10

**1. Screenshot Sebelum (v0.3)**

![Screenshot Sebelum](outputtp8_sesudah.png)

**2. Screenshot Sesudah (v0.4)**

![Screenshot Sesudah](outputtp10_sesudah.png)


## Struktur Folder Project

```text
CharacterrManager/
├── README.md
├── Screenshot_JavaVisual/
│   ├── outputtp3.png
│   ├── outputtp5.png
│   ├── outputtp8_sebelum.png
│   ├── outputtp8_sesudah.png
│   ├── outputtp10_sebelum.png
│   └── outputtp10_sesudah.png
└── src/
    └── com/
        └── unpri/
            └── charactermanager/
                ├── model/
                │   ├── Character.java
                │   ├── CharacterType.java
                │   ├── CharacterManager.java
                │   └── Main.java
                └── view/
                    ├── AppTheme.java
                    └── MainWindow.java
```

## Identitas Mahasiswa

**Nama:** Karyn Natashia Siregar

**NIM:** 253303621220

**Link Google Docs:** [Dokumen TP3](https://1drv.ms/w/c/EF681E4F4E3CE288/IQA3LqwMH3jhSJLam470mUvfASUPnESEdle9STdoZw2fhDc?e=EaE6bd)

**Link Google Docs:** [Dokumen TP5](https://1drv.ms/w/c/3F04BCD0705D5ACD/IQCLGfsidsMiQ6f3CYXbPwSnAcmlPmaHwItOcZx_zgjckoU?e=fP7UHj)

**Link Google Docs:** [Dokumen TP8](https://1drv.ms/w/c/3F04BCD0705D5ACD/IQDnqhN2Jpn4Rp3ahwA7BP03AS-uqR3VP1WR10uLFd25Tnc?e=pPrdza)

**Link Google Docs:** [Dokumen TP10](https://1drv.ms/w/c/3F04BCD0705D5ACD/IQDuikKgx-H_S4gKuaxh5EmKAccUjEZNhukfo18XjG8CeV0?e=3HbceO)
