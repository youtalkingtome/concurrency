package collectors;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class PrimeCounting {

    static long pi(long n)
    {
        return LongStream.rangeClosed(2,n).parallel().mapToObj(BigInteger::valueOf)
                .filter(i-> i.isProbablePrime(50)).count();
    }
    static long piNP(long n)
    {
        return LongStream.rangeClosed(2,n).mapToObj(BigInteger::valueOf)
                .filter(i-> i.isProbablePrime(50)).count();
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        //Calling Parallel example
        pi(1000);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime; // elapsed time in milliseconds
        System.out.println("Elapsed Time in milliseconds Using Parallel: " + elapsedTime);


        long startTime1 = System.currentTimeMillis();
        //Calling Parallel example
        piNP(100);
        long endTime1 = System.currentTimeMillis();
        long elapsedTime1 = endTime1 - startTime1; // elapsed time in milliseconds
        System.out.println("Elapsed Time in milliseconds Using Non Parallel: " + elapsedTime1);

    }
}
