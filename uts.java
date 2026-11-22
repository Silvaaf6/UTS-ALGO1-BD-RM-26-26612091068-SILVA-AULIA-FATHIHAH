import java.util.Scanner;
import java.util.Arrays;

public class uts {

    // Menentukan grade berdasarkan nilai
    public static String grade(int nilai) {
        if (nilai >= 90) {
            return "A";
        } else if (nilai >= 80) {
            return "B";
        } else if (nilai >= 60) {
            return "C";
        } else if (nilai >= 40) {
            return "D";
        } else {
            return "E";
        }
    }

    // Menentukan keterangan nilai
    public static String keterangan(int nilai) {
        if (nilai >= 90) {
            return "Lulus nilai terbaik";
        } else if (nilai >= 80) {
            return "Lulus";
        } else if (nilai >= 60) {
            return "Lulus ala kadarnya";
        } else if (nilai >= 40) {
            return "Perlu Diperbaiki";
        } else {
            return "Tidak Lulus";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Memasukkan NPM 
        System.out.print("Masukkan NPM: ");
        String npm = input.nextLine();

        // Memeriksa apakah NPM berupa angka dan minimal 2 digit
        if (npm.length() < 2 || !npm.matches("[0-9]+")) {
            System.out.println("NPM tidak valid!");
            return;
        }

        // Mengambil dua angka terakhir NPM sebagai nilai awal
        int nilaiAwal = Integer.parseInt(
            npm.substring(npm.length() - 2)
        );

        // Nilai akhir dimulai dari nilai awal
        int nilaiAkhir = nilaiAwal;
        int jumlahRemedial = 0;

        // Menampilkan hasil nilai awal mahasiswa
        System.out.println("\n===== HASIL NILAI MAHASISWA =====");
        System.out.println("NPM        : " + npm);
        System.out.println("Nilai Awal : " + nilaiAwal);
        System.out.println("Grade      : " + grade(nilaiAwal));
        System.out.println("Keterangan : " + keterangan(nilaiAwal));

        // Memeriksa apakah mahasiswa perlu mengikuti remedial
        System.out.println("\n===== PROSES REMEDIAL =====");

        if (nilaiAwal < 60) {

            // Menambah nilai 10 poin setiap remedial sampai minimal 60
            while (nilaiAkhir < 60) {
                jumlahRemedial++;
                nilaiAkhir += 10;

                System.out.println(
                    "Remedial ke-" + jumlahRemedial +
                    ", nilai menjadi: " + nilaiAkhir
                );
            }

        } else {
            System.out.println("Tidak perlu mengikuti remedial.");
        }

        // Menampilkan nilai setelah remedial
        System.out.println("\n===== HASIL AKHIR =====");
        System.out.println("Nilai Akhir  : " + nilaiAkhir);
        System.out.println("Grade Akhir  : " + grade(nilaiAkhir));
        System.out.println("Keterangan   : " + keterangan(nilaiAkhir));

        // Menyimpan nilai ke dalam array
        int[] dataNilai = {
            nilaiAwal, nilaiAkhir, 60, 80, 90, 100
        };

        // Menentukan algoritma berdasarkan nilai awal
        if (nilaiAwal % 2 != 0) {

            // Jika nilai awal ganjil, menggunakan Sequential Search
            System.out.println("\n===== ALGORITMA SEQUENTIAL SEARCH =====");

            int cari = nilaiAkhir;
            int flag = 0;
            int posisi = -1;

            System.out.println("Data yang dicari: " + cari);

            // Mencari nilai satu per satu dari awal array
            for (int i = 0; i < dataNilai.length; i++) {
                if (dataNilai[i] == cari) {
                    flag = 1;
                    posisi = i;
                    break;
                }
            }

            // Menampilkan apakah nilai ditemukan atau tidak
            if (flag == 1) {
                System.out.println("Data ada pada indeks ke-" + posisi);
            } else {
                System.out.println("Data tidak ada");
            }

        } else {

            // Jika nilai awal genap, menggunakan Bubble Sort
            System.out.println("\n===== ALGORITMA BUBBLE SORT =====");

            // Menampilkan data sebelum diurutkan
            System.out.println(
                "Data sebelum diurutkan: " + Arrays.toString(dataNilai)
            );

            int tukar;

            // Membandingkan nilai yang bersebelahan
            for (int i = dataNilai.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {

                    // Menukar posisi jika nilai kiri lebih besar
                    if (dataNilai[j] > dataNilai[j + 1]) {
                        tukar = dataNilai[j];
                        dataNilai[j] = dataNilai[j + 1];
                        dataNilai[j + 1] = tukar;
                    }
                }
            }

            // Menampilkan hasil pengurutan dari kecil ke besar
            System.out.println(
                "Data setelah diurutkan: " + Arrays.toString(dataNilai)
            );
        }

        input.close();
    }
}
