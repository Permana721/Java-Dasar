public class RecursiveMethod {
    static void main(String[] args) {
        System.out.println(factorialLoop(10));
        System.out.println(factorialRecursive(10));

        loop(1000000);
    }

    static int factorialLoop(int value){
        var result = 1;

        for(var counter = 1; counter <= value; counter++){
            result *= counter;
        }
        return result;
    }

//  Recursive method
    static int factorialRecursive(int value){
        if(value == 1){
            return 1;
        } else {
            return value * factorialRecursive(value - 1);
        }
    }

//  Error StackOverflow
    static void loop(int value){
        if(value == 0){
            System.out.println("Selesai");
        } else {
            System.out.println("Loop ke - " + value);
            loop(value - 1);
        }
    }
}