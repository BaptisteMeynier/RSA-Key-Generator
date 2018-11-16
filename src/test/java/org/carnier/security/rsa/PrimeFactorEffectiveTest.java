package org.carnier.security.rsa;

import org.junit.*;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class PrimeFactorEffectiveTest {


    private long start;
    private long end;

    @Before
    public void startChrono() {
        start = System.nanoTime();
    }

    @After
    public void endChrono() {
         end = System.nanoTime();
        System.out.println("Temps d'execution  = " + Math.abs(end - start) + " ns");
        System.out.println("Temps d'execution  = " + TimeUnit.NANOSECONDS.toMillis(Math.abs(end - start)) + " ms");
    }

    @Test
    public void primeFactorsWithInt_should_return_list_of_prime_factor_with_small_even_number() {
        List<Integer> factors = PrimeFactorEffective.primeFactorsWithInt(44);
        Assert.assertTrue(factors.contains(2));
        Assert.assertTrue(factors.size() > 1);
    }

    @Test
    public void primeFactorsWithInt_should_return_list_of_prime_factor_with_small_odd_number() {
        List<Integer> factors = PrimeFactorEffective.primeFactorsWithInt(33);
        Assert.assertTrue(factors.contains(11));
        Assert.assertTrue(factors.size() > 1);
    }

    @Test
    public void primeFactorsWithInt_should_not_return_itself_with_no_prime_number() {
        List<Integer> factors = PrimeFactorEffective.primeFactorsWithInt(44);
        Assert.assertFalse(factors.contains(44));
        Assert.assertTrue(factors.size() > 1);
    }

    @Test
    public void primeFactorsWithInt_should_return_prime_value_with_prime_number() {
        List<Integer> factors = PrimeFactorEffective.primeFactorsWithInt(43);
        Assert.assertTrue(factors.contains(43));
        Assert.assertEquals(1, factors.size());
    }

    /////////

    @Test
    public void should_return_list_of_prime_factor_with_small_even_number() {
        List<BigInteger> factors = PrimeFactorEffective.primeFactors(BigInteger.valueOf(44));
        Assert.assertTrue(factors.contains(BigInteger.valueOf(2)));
        Assert.assertTrue(factors.size() > 1);
    }

    @Test
    public void should_return_list_of_prime_factor_with_small_odd_number() {
        List<BigInteger> factors = PrimeFactorEffective.primeFactors(BigInteger.valueOf(33));
        Assert.assertTrue(factors.contains(BigInteger.valueOf(11)));
        Assert.assertTrue(factors.size() > 1);
    }

    @Test
    public void should_not_return_itself_with_no_prime_number() {
        List<BigInteger> factors = PrimeFactorEffective.primeFactors(BigInteger.valueOf(44));
        Assert.assertFalse(factors.contains(BigInteger.valueOf(44)));
        Assert.assertTrue(factors.size() > 1);
    }

    @Test
    public void should_return_prime_value_with_prime_number() {
        List<BigInteger> factors = PrimeFactorEffective.primeFactors(BigInteger.valueOf(43));
        Assert.assertTrue(factors.contains(BigInteger.valueOf(43)));
        Assert.assertEquals(1, factors.size());
    }

    @Test
    public void should_return_list_of_factor_with_one_hundrer_thousand() {
        List<BigInteger> factors = PrimeFactorEffective.primeFactors(new BigInteger("100000", 10));
           Assert.assertTrue(factors.contains(BigInteger.valueOf(5)));
            Assert.assertTrue(1<factors.size());
    }

    @Test
    public void should_return_list_of_factor_with_one_billion() {
        List<BigInteger> factors = PrimeFactorEffective.primeFactors(new BigInteger("100000000", 10));
        Assert.assertTrue(factors.contains(BigInteger.valueOf(5)));
        Assert.assertTrue(1<factors.size());
    }

    @Test
    @Ignore
    public void should_return_list_of_factor_with_a_number_with_31_digits() {
        BigInteger bigInteger = new BigInteger("10000000100545528547321", 10);
        System.out.println(bigInteger.bitCount());
        List<BigInteger> factors = PrimeFactorEffective.primeFactors(new BigInteger("10000000100545528547321", 10));
        //   Assert.assertTrue(factors.contains(BigInteger.valueOf(43)));
        //     Assert.assertEquals(1,factors.size());
    }

    @Test
    public void primeFactorsStream_should_return_list_of_factor_with_an_int() {
        IntStream intStream = PrimeFactorEffective.primeFactorsStream(100000000);
        //intStream.forEach(val -> System.out.println(val));
    }

}