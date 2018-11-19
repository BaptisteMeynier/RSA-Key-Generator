package org.carnier.security.rsa;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Hello world!
 */
public class App {
    /**
     * 1) Choisir p et q, deux nombres premiers distincts ;
     * 2) calculer leur produit n = pq, appelé module de chiffrement ;
     * 3) calculer φ(n) = (p - 1)(q -1) (c'est la valeur de l'indicatrice d'Euler en n) ;
     * 4) choisir un entier naturel e premier avec φ(n) et strictement inférieur à φ(n), appelé exposant de chiffrement ;
     * 5) calculer l'entier naturel d, inverse de e modulo φ(n), et strictement inférieur à φ(n), appelé exposant de déchiffrement ; d peut se calculer efficacement par l'algorithme d'Euclide étendu.
     *
     * @param args Un exemple avec de petits nombres premiers (en pratique il faut de très grands nombres premiers) :
     *             <p>
     *             on choisit deux nombres premiers p = 3, q = 11 ;
     *             leur produit n = 3 × 11 = 33 est le module de chiffrement ;
     *             φ(n) = (3 – 1) × (11 – 1) = 2 × 10 = 20 ;
     *             on choisit e= 3 (premier avec 20) comme exposant de chiffrement ;
     *             l'exposant de déchiffrement est d = 7, l'inverse de 3 modulo 20 (en effet ed = 3 × 7 ≡ 1 mod 20).
     *             <p>
     *             La clé publique d'Alice est (n, e) = (33, 3), et sa clé privée est (n, d) = (33, 7). Bob transmet un message à Alice.
     *             <p>
     *             Chiffrement de M = 4 par Bob avec la clé publique d'Alice : 43 ≡ 31 mod 33, le chiffré est C = 31 que Bob transmet à Alice ;
     *             Déchiffrement de C = 31 par Alice avec sa clé privée : 317 ≡ 4 mod 33, Alice retrouve le message initial M = 4.
     *             <p>
     *             Le mécanisme de signature par Alice, à l'aide de sa clé privée, est analogue, en échangeant les clés.
     */
/*
    BigInteger encrypt(BigInteger publicKey, BigInteger message) {
        return message.modPow(publicKey, modulus);
    }

    BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(privateKey, modulus);
    }*/

    public static void main(String[] args) {
        int bitLenght = 256;
        //1)

        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(bitLenght / 2, 100, r);
        BigInteger q = new BigInteger(bitLenght / 2, 100, r);

        //2)
        BigInteger n = p.multiply(q);

        //3)
        BigInteger phiN = p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1)));

        //4)
        BigInteger e;
        do {
            e = new BigInteger(bitLenght,100, r);
        } while (!phiN.gcd(e).equals(BigInteger.ONE) && e.compareTo(phiN) == -1);

        BigInteger d = e.modInverse(phiN);

        System.out.println("Public key:(n,e) (" + n + "," + e + ")");
        System.out.println("Private key: d (" + d + ")");

    }
}
