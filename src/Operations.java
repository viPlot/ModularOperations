import java.math.BigInteger;

public class Operations {
    private static final BigInteger ONE = new BigInteger("1");
    private static final BigInteger ZERO = new BigInteger("0");

    public Operations(){
    }

    public void addition(BigInteger fNum, BigInteger sNum, BigInteger m) {
        BigInteger sum = fNum.mod(m).add(sNum.mod(m)).mod(m);
        System.out.println("> Результат сложения по модулю: " + fNum + " + " + sNum +
                " (mod " + m + ") = " + sum);
    }

    public void subtraction(BigInteger fNum, BigInteger sNum, BigInteger m) {
        if (fNum.compareTo(sNum) == 1) {
            BigInteger diff = (fNum.mod(m).subtract(sNum.mod(m))).mod(m);
            System.out.println("> Результат вычитания по модулю: " + fNum + " - " + sNum +
                    " (mod " + m + ") = " + diff);
        }
        else {
            BigInteger diffElse = fNum.mod(m).subtract(sNum.mod(m)).mod(m);
            diffElse.add(m);
            System.out.println("> Результат вычитания по модулю: " + fNum + " - " + sNum +
                    " (mod " + m + ") = " + diffElse);
        }
    }

    public void multiplication(BigInteger fNum, BigInteger sNum, BigInteger m) {
        BigInteger mult = fNum.mod(m).multiply(sNum.mod(m)).mod(m);
        System.out.println("> Результат умножения по модулю: " + fNum + " * " + sNum +
                " (mod " + m + ") = " + mult);
    }

    public void division(BigInteger fNum, BigInteger sNum, BigInteger m) {
        if (sNum.gcd(m).compareTo(ONE) == 0) {
            if (sNum.compareTo(ZERO) != 0) {
                BigInteger invNum = sNum.modInverse(m);
                BigInteger div = (fNum.multiply(invNum).mod(m));
                System.out.println("> Результат деления по модулю: " + fNum + " / " + sNum +
                        " (mod " + m + ") = " + div);
            } else
                System.out.println("! Ошибка: деление нельзя выполнить, потому что делитель является нулем");
        }
        else
            System.out.println("! Ошибка: нельзя выполнить действие деления, потому что a и mod невзаимно простые числа");
    }

    public void additiveInverse(BigInteger fNum, BigInteger sNum, BigInteger m) {
        //здесь поиск аддитивной инверсии к числу  вычисляетсчя так: b = n - a (n - модуль),
        //что значит то же самое, что и a + b ≡ 0 (mod n)
        BigInteger firstInv = m.subtract(fNum);
        BigInteger secondInv = m.subtract(sNum);
        System.out.println("> Результат аддитивной инверсии первого числа: " + firstInv +
                " , результат аддитивной инверсии второго числа: " + secondInv);
    }

    public void multiplicativeInverse(BigInteger fNum, BigInteger sNum, BigInteger mod) {
        //мультипликативная инверсия - это поиск обратного числа по модулю
        if (fNum.gcd(mod).compareTo(ONE) == 0 | sNum.gcd(mod).compareTo(ONE) == 0) {
            BigInteger fInv = fNum.modInverse(mod);
            BigInteger sInv = sNum.modInverse(mod);
            System.out.println("> Результат мультипликативной инверсии первого числа: " + fInv +
                    " , результат мультипликативной инверсии второго числа: " + sInv);
        }
        else System.out.println("! Ошибка: нельзя выполнить поиск мультипликативной инверсии, потому что одна из пар чисел невзаимно простые числа");
    }

    public void exponentiation(BigInteger fNum, BigInteger sNum, BigInteger m) {
        BigInteger exp = fNum.pow(sNum.intValue());
        BigInteger done =  exp.mod(m);
        System.out.println("> Результат возведения в степень по модулю: " + fNum + "^" + sNum +
                " (mod " + m + ") = " + done);
    }
}