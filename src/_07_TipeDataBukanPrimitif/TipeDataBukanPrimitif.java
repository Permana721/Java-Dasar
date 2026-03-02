package _07_TipeDataBukanPrimitif;
/**
 * Tipe data primitif adalah tipe bawaan di dalam bahasa pemrograman. Tipe data primitif tidak bisa diubah lagi
 * Tipe data number, char, boolean adalah tipe data primitif. Tipe data primitif selalu memiliki default value
 * Tipe data String bukan tipe data primitif, tipe data bukan primitif tidak memiliki default value, dan bisa bernilai null
 * Tipe data bukan primitif bisa memiliki method/function (yang akan dibahas nanti)
 * Di Java, semua tipe data primitif memiliki representasi tipe data bukan primitif nya
 * Tipe data bukan primitif juga bisa digunakan untuk menyimpan data number, char, boolean, dan String, namun dengan fitur tambahan yang tidak dimiliki oleh tipe data primitif
 */
public class TipeDataBukanPrimitif {
    public static void main(String[] args) {

        Integer iniInteger = 100;
        Long iniLong = 10000L;

        Byte iniByte = null;

        System.out.println(iniByte);

        iniByte = 100;

        System.out.println(iniByte);

        int iniInt = 100;

        Integer iniObject = iniInt;

        short iniShort = iniObject.shortValue();
        long iniLong2 = iniObject.longValue();
        float iniFloat = iniObject.floatValue();

        Long amount = 1000000L;

    }
}