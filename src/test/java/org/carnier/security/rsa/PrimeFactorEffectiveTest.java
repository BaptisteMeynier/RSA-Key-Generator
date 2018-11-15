package org.carnier.security.rsa;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.Assert.*;

public class PrimeFactorEffectiveTest {

    @Test
    public void primeFactorsWithInt_should_return_list_of_prime_factor_with_small_even_number(){
        List<Integer> factors = PrimeFactorEffective.primeFactorsWithInt(44);
        Assert.assertTrue(factors.contains(2));
        Assert.assertTrue(factors.size()>1);
    }

    @Test
    public void primeFactorsWithInt_should_return_list_of_prime_factor_with_small_odd_number(){
        List<Integer> factors = PrimeFactorEffective.primeFactorsWithInt(33);
        Assert.assertTrue(factors.contains(11));
        Assert.assertTrue(factors.size()>1);
    }

    @Test
    public void primeFactorsWithInt_should_not_return_itself_with_no_prime_number(){
        List<Integer> factors = PrimeFactorEffective.primeFactorsWithInt(44);
        Assert.assertFalse(factors.contains(44));
        Assert.assertTrue(factors.size()>1);
    }

    @Test
    public void primeFactorsWithInt_should_return_prime_value_with_prime_number(){
        List<Integer> factors = PrimeFactorEffective.primeFactorsWithInt(43);
        Assert.assertTrue(factors.contains(43));
        Assert.assertEquals(1,factors.size());
    }

    /////////

    @Test
    public void should_return_list_of_prime_factor_with_small_even_number(){
        List<BigInteger> factors = PrimeFactorEffective.primeFactors(BigInteger.valueOf(44));
        Assert.assertTrue(factors.contains(BigInteger.valueOf(2)));
        Assert.assertTrue(factors.size()>1);
    }

    @Test
    public void should_return_list_of_prime_factor_with_small_odd_number(){
        List<BigInteger> factors = PrimeFactorEffective.primeFactors(BigInteger.valueOf(33));
        Assert.assertTrue(factors.contains(BigInteger.valueOf(11)));
        Assert.assertTrue(factors.size()>1);
    }

    @Test
    public void should_not_return_itself_with_no_prime_number(){
        List<BigInteger> factors = PrimeFactorEffective.primeFactors(BigInteger.valueOf(44));
        Assert.assertFalse(factors.contains(BigInteger.valueOf(44)));
        Assert.assertTrue(factors.size()>1);
    }

    @Test
    public void should_return_prime_value_with_prime_number(){
        List<BigInteger> factors = PrimeFactorEffective.primeFactors(BigInteger.valueOf(43));
        Assert.assertTrue(factors.contains(BigInteger.valueOf(43)));
        Assert.assertEquals(1,factors.size());
    }

    @Test
    public void should_return_list_of_factor_with_one_hundrer_thousand(){
        List<BigInteger> factors = PrimeFactorEffective.primeFactors(new BigInteger("100000",10));
     //   Assert.assertTrue(factors.contains(BigInteger.valueOf(43)));
    //    Assert.assertEquals(1,factors.size());
    }

    @Test
    public void should_return_list_of_factor_with_one_billion(){
        List<BigInteger> factors = PrimeFactorEffective.primeFactors(new BigInteger("100000000",10));
     //   Assert.assertTrue(factors.contains(BigInteger.valueOf(43)));
   //     Assert.assertEquals(1,factors.size());
    }

    @Test
    public void should_return_list_of_factor_with_a_number_with_31_digits(){
        List<BigInteger> factors = PrimeFactorEffective.primeFactors(new BigInteger("10000000100545528547321",10));
        String res="";
        //   Assert.assertTrue(factors.contains(BigInteger.valueOf(43)));
        //     Assert.assertEquals(1,factors.size());
    }

}