package structuredconcurrency;

import java.math.BigInteger;

public class LcmExamples {

        public static BigInteger lcm(BigInteger a, BigInteger b) {
            return a.multiply(b).divide(a.gcd(b));
        }

        public static void main(String[] args) {
            BigInteger num1 = new BigInteger("256");
            BigInteger num2 = new BigInteger("64");

            BigInteger result = lcm(num1, num2);
            System.out.println("LCM: " + result); // Output: LCM: 36
        }
    }

