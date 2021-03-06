package org.carnier.security.rsa;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * http://www.vogella.com/tutorials/JavaAlgorithmsPrimeFactorization/article.html
 */
public class PrimeFactorEffective {
    public static List<BigInteger> primeFactors(BigInteger numbers) {
        BigInteger n = numbers;
        List<BigInteger> factors = new ArrayList<>();
        for (BigInteger i = BigInteger.TWO; i.compareTo(n.divide(i)) <=0 ; i=i.add(BigInteger.ONE)) {
            while (n.mod(i).equals(BigInteger.ZERO)) {
                factors.add(i);
                n = n.divide(i);
            }
        }
        if (n.compareTo(BigInteger.ONE) > 0 ) {
            factors.add(n);
        }
        return factors;
    }

    public static IntStream primeFactorsStream(int number) {
        return IntStream.range(2, number-1)
                .filter(i -> number % i == 0 && !primeFactorsStream(i).findAny().isPresent());
    }

    public static List<Integer> primeFactorsWithInt(int numbers) {
        int n = numbers;
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }
}
