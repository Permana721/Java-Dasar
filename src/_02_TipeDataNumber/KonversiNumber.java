package _02_TipeDataNumber;
// Konversi Number adalah proses mengubah nilai dari satu tipe data number ke tipe data number lainnya
public class KonversiNumber {
    public static void main(String[] args) {
        byte iniByte = 100;
        short iniShort = iniByte;
        int iniInt = iniShort;

        int iniInt2 = 1000;
        byte iniByte2 = (byte) iniInt2;
    }
}
