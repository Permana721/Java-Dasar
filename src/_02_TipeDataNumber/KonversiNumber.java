package _02_TipeDataNumber;

public class KonversiNumber {
    public static void main(String[] args) {
        byte iniByte = 100;
        short iniShort = iniByte;
        int iniInt = iniShort;
        // System.out.println(iniInt); // Output: 100

        int iniInt2 = 1000;
        byte iniByte2 = (byte) iniInt2;
        // System.out.println(iniByte2); // Output: -24 (overflow terjadi karena nilai melebihi batas byte)
    }
}
