import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static int lastFakturNumber = 0;
public class Login extends Captcha{
    private static final String usernameKey="angelio";
    private static final String passwordKey="1204";

    public static boolean AdminLogin (String username, String password, String inputCaptcha, String Captcha){
        return username.equals(usernameKey) && password.equals(passwordKey) && inputCaptcha.equalsIgnoreCase(Captcha);
    }
}
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean lanjutTransaksi = true;
        boolean lanjutLogin = true;

        System.out.println();
        while (lanjutLogin) {
            String username="";
            String password="";
            String captcha="";
            String z = Captcha.generateCaptcha();
            try {
                    System.out.print("Username\t: ");
                    username = scanner.next();
                    System.out.print("Password\t: ");
                    password = scanner.next();
                    System.out.println("Kode captcha\t: " + z);
                    System.out.print("Captcha\t\t: ");
                    captcha = scanner.next();
                    if (Login.AdminLogin(username, password, captcha, z)) {
                        System.out.println("Login successful!");
                        lanjutTransaksi = true;
                    } else {
                        System.out.println("Invalid username, password, or captcha. Please try again.");
                        lanjutTransaksi = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Periksa kembali Username, Password, dan Captcha");
                    scanner.next();
                }
            while (lanjutTransaksi) {
                Integer noFaktur = ++lastFakturNumber;
                System.out.println();
                System.out.println("No. Faktur\t: " + noFaktur);

                System.out.print("Nama Pelanggan\t: ");
                String namaPelanggan = scanner.next();

                System.out.print("No HP\t\t: ");
                String noHp = scanner.next();

                System.out.print("Alamat\t\t: ");
                String alamat = scanner.next();

                System.out.print("Kode Barang\t: ");
                String kode = scanner.next();

                System.out.print("Nama Barang\t: ");
                String namaBarang = scanner.next();

                boolean inputHargaValid = false;
                double hargaBarang = 0;
                while (!inputHargaValid) {
                    try {
                        System.out.print("Harga Barang\t: ");
                        hargaBarang = scanner.nextDouble();
                        inputHargaValid = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Input harga barang tidak valid. Silakan coba lagi.");
                        scanner.next();
                    }
                }

                int jumlahBarang = 0;
                boolean inputJumlahValid = false;
                while (!inputJumlahValid) {
                    try {
                        System.out.print("Jumlah Barang\t: ");
                        jumlahBarang = scanner.nextInt();
                        if (jumlahBarang <= 0) {
                            throw new ArithmeticException("Jumlah barang harus lebih dari 0.");
                        }
                        inputJumlahValid = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Input jumlah barang tidak valid. Silakan coba lagi.");
                        scanner.next();
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                System.out.print("Kasir\t\t: ");
                String kasir = scanner.next();

                Transaksi transaksi = new Transaksi(noFaktur, namaPelanggan, noHp, alamat, kode, namaBarang, hargaBarang,
                    jumlahBarang, kasir);
                System.out.println();
                transaksi.tampilkanDetailTransaksi();

                System.out.println();
                System.out.print("Lanjut ke transaksi berikutnya? (ya/tidak): ");

                String jawaban = scanner.next().toLowerCase();
                lanjutTransaksi = jawaban.equals("ya");
            }
        System.out.println("Terima Kasih");
        scanner.close();
        }
    }
}