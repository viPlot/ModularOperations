import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите первое число: ");
        BigInteger frstNum = setNum();
        System.out.print("Введите второе число: ");
        BigInteger scndNum = setNum();
        System.out.print("Введите модуль: ");
        BigInteger mod = setNum();

        Operations op = new Operations();
        op.addition(frstNum, scndNum, mod);
        op.subtraction(frstNum, scndNum, mod);
        op.multiplication(frstNum, scndNum, mod);
        op.division(frstNum, scndNum, mod);
        op.multiplicativeInverse(frstNum, scndNum, mod);
        op.additiveInverse(frstNum, scndNum, mod);
        op.exponentiation(frstNum, scndNum, mod);
    }

    private static BigInteger setNum(){
        Scanner in = new Scanner(System.in);
        BigInteger num = in.nextBigInteger();
        return num;
    }
}