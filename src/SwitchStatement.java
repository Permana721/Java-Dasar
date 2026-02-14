public class SwitchStatement {
    public static void main(String[] args) {
        var nilai = "C";

        switch (nilai) {
            case "A":
                System.out.println("Anda lulus dengan baik");
                break;
            case "B":
                System.out.println("Nilai anda cukup baik");
                break;
            case "C":
                System.out.println("Nilai anda perlu perbaikan");
                break;
            case "D":
                System.out.println("Anda tidak lulus");
                break;
            default:
                System.out.println("Anda mungkin salah jurusan");
        }

        //  Switch Lambda
        switch (nilai) {
            case "A" -> System.out.println("Anda lulus dengan baik");
            case "B" -> System.out.println("Nilai anda cukup baik");
            case "C" -> System.out.println("Nilai anda perlu perbaikan");
            case "D" -> System.out.println("Anda  tidak lulus");
            default -> System.out.println("Anda mungkin salah jurusan");
        }

        // Switch tanpa yield
        String ucapan;
        switch (nilai) {
            case "A" -> ucapan = ("Anda lulus dengan baik");
            case "B", "C" -> ucapan = ("Nilai anda cukup baik");
            case "D" -> ucapan = ("Anda  tidak lulus");
            default -> ucapan = ("Anda mungkin salah jurusan");
        }
        System.out.println(ucapan);

        // Switch dengan yield
        ucapan = switch (nilai){
            case "A": yield "Anda lulus dengan baik";
            case "B", "C": yield "Nilai anda cukup baik";
            case "D": yield "Anda  tidak lulus";
            default: yield  "Anda mungkin salah jurusan";
        };
        System.out.println(ucapan);
    }
}