package BreakAndContinue;
/*
Pada switch statement, kita sudah mengenal kata kunci break, yaitu untuk menghentikan case dalam switch
Sama dengan pada perulangan, break juga digunakan untuk menghentikan seluruh perulangan.
 */
public class Break {
    public static void main(String[] args) {
        var counter = 1;

        while (true){
            System.out.println("Perulangan ke " + counter);
            counter++;

            if(counter > 10){
                break;
            }
        }

        System.out.println("Perulangan berhenti");
    }
}
