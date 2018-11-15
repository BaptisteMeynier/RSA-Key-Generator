package org.carnier.security.rsa;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ComputePrime {

    //4)
    //il faut calculer la racine de phiN et prendre la partie entiere parceque tous les nombre premiers diviseur de phiN sont forcément inférieur a la racine de phiN (demander a Simon pour la demonstration)
    //décomposer phiN en produit de facteurs premier, ces facteurs doivent etre plus petit que racine de phiN (le faire a partir de (p-1) et (q-1) plus petit que de le faire sur le produit
    //resultat possible : 3^2 * 2^4 * 5^1
    //Générer un tableau de tuple nombre premier et exposant
    //Parallelelement on a un tableau de tous les nombres premier inférieur a racine de phiN
    // et on y affecte un booleen pour répertorier les nombres premiers diviseurs de phiN
    // ensuite
    // exemple :
    //

    //deux strategies :
    // - soit on fournit une estimation de racine de PhiN
    //    explication:
    // - soit on calcule vraime,nt racine de phiN



    public BigInteger execute(final BigInteger p,final BigInteger q ){

        BigInteger n = p.multiply(q);

        BigInteger phiN = p.min(BigInteger.valueOf(1)).multiply(q.min(BigInteger.valueOf(1)));
        BigInteger phiNSqrt = phiN.sqrt();
       // phiN.divideAndRemainder()

        return null;
    }

}
