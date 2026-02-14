package Variabel;

public class Variable {
    public static void main(String[] args) {
        String name;
        name = "Permana Surya Dharma";

        System.out.println(name);

        int age = 18;
        String address = "Indonesia";

        System.out.println(age);
        System.out.println(address);

        name = "Arido Shifuka";
        System.out.println(name);

        var firstName = "Permana";
        var middleName = "Surya";
        var lastName = "Dharma";

        // var company; error(kalau mau pake "var" isi dari variabel harus langsung di deklarasi)
        var company = "IPUH Corp";
        System.out.println(company);

        // final String application = "Belajar Java";
        // application = "Belajar PHP"; error karena final = const
    }
}