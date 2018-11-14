package org.carnier.security.rsa;

import java.math.BigDecimal;
import java.math.BigInteger;

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

    public static void main(String[] args) {
        //1)
        BigInteger p = BigInteger.valueOf(41);
        BigInteger q = BigInteger.valueOf(19);

        //2)
        BigInteger n = p.multiply(q);

        //3)
        BigInteger phiN = p.min(BigInteger.valueOf(1)).multiply(q.min(BigInteger.valueOf(1)));

         //4)
        //il faut calculer la racine de phiN et prendre la partie entiere parceque tous les nombre premiers diviseur de phiN sont forcément inférieur a la racine de phiN (demander a Simon pour la demonstration)
        //décomposer phiN en produit de facteurs premier, ces facteurs doivent etre plus petit que racine de phiN (le faire a partir de (p-1) et (q-1) plus petit que de le faire sur le produit
        //resultat possible : 3^2 * 2^4 * 5^1
        //Générer un tableau de tuple nombre premier et exposant
        //Parallelelement on a un tableau de tous les nombres premier inférieur a racine de phiN
        // et on y affecte un booleen pour répertorier les nombres premiers diviseurs de phiN
        // exemple :
        //



        //4)


        System.out.println("Hello World!");
    }
}
