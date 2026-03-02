package _12_ExpressionStatementandBlock;
import java.util.Date;
/*
Block adalah kumpulan statement yang terdiri dari nol atau lebih statement.
Block diawali dan diakhiri dengan kurung kurawal { }
 */
public class Block {
    static void main(String[] args) {
        { // code block
            double aValue = 8933.243;
            aValue++;
            System.out.println(aValue);
        }
        Date date = new Date();
    }
}
