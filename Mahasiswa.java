import java.util.HashMap;
import java.util.Scanner;

public class Mahasiswa {

    public static void main(String[] args) {
        HashMap<HashMap<String, String>, Integer> dataMahasiswa = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Hapus Data Mahasiswa");
            System.out.println("3. Cetak Data Mahasiswa");
            System.out.println("4. Cetak Nilai Mahasiswa berdasarkan NIM");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membuang newline dari buffer

            switch (choice) {
                case 1:
                    tambahDataMahasiswa(dataMahasiswa, scanner);
                    break;
                case 2:
                    hapusDataMahasiswa(dataMahasiswa, scanner);
                    break;
                case 3:
                    cetakDataMahasiswa(dataMahasiswa);
                    break;
                case 4:
                    cetakNilaiMahasiswa(dataMahasiswa, scanner);
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang tersedia.");
            }
        }
    }

    public static void tambahDataMahasiswa(HashMap<HashMap<String, String>, Integer> dataMahasiswa, Scanner scanner) {
        HashMap<String, String> data = new HashMap<>();
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine();
        data.put("nama", nama);

        System.out.print("Masukkan Kelas Mahasiswa: ");
        String kelas = scanner.nextLine();
        data.put("kelas", kelas);

        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = scanner.nextLine();
        data.put("nim", nim);

        System.out.print("Masukkan Nilai Mahasiswa: ");
        int nilai = scanner.nextInt();
        scanner.nextLine(); // Membuang newline dari buffer

        // Menambahkan data mahasiswa ke dalam hashmap utama
        dataMahasiswa.put(data, nilai);
        System.out.println("Data mahasiswa berhasil ditambahkan!");
    }

    public static void hapusDataMahasiswa(HashMap<HashMap<String, String>, Integer> dataMahasiswa, Scanner scanner) {
        System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
        String nim = scanner.nextLine();

        // Menghapus data mahasiswa berdasarkan NIM
        boolean removed = false;
        for (HashMap<String, String> key : dataMahasiswa.keySet()) {
            if (key.containsKey("nim") && key.get("nim").equals(nim)) {
                dataMahasiswa.remove(key);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Data mahasiswa dengan NIM " + nim + " berhasil dihapus!");
        } else {
            System.out.println("Data mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    public static void cetakDataMahasiswa(HashMap<HashMap<String, String>, Integer> dataMahasiswa) {
        if (dataMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa yang tersimpan.");
        } else {
            System.out.println("\nData Mahasiswa yang Telah Disimpan:");
            for (HashMap<String, String> key : dataMahasiswa.keySet()) {
                String nama = key.get("nama");
                String kelas = key.get("kelas");
                String nim = key.get("nim");
                int nilai = dataMahasiswa.get(key);

                System.out.println("NIM: " + nim + ", Nama: " + nama + ", Kelas: " + kelas + ", Nilai: " + nilai);
            }
        }
    }

    public static void cetakNilaiMahasiswa(HashMap<HashMap<String, String>, Integer> dataMahasiswa, Scanner scanner) {
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = scanner.nextLine();
        boolean found = false;

        for (HashMap<String, String> key : dataMahasiswa.keySet()) {
            if (key.containsKey("nim") && key.get("nim").equals(nim)) {
                int nilai = dataMahasiswa.get(key);
                System.out.println("Nilai Mahasiswa dengan NIM " + nim + " adalah: " + nilai);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Data mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }
}
