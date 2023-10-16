public class Main {
    public static void main(String[] args) {
        final long n = 64806601923671L;
        final long[] pq = Fermat.fermatSolve(n);
        final long e = 3676721L;
        final long[] msg = {
                20691828453967L,
                58551582619533L,
                52687210920168L,
                20981648665029L,
                19111617348524L,
                54100651527277L,
                13292121860367L,
                56392703591321L,
                14438767538210L,
                42480181826283L,
                48812319440355L,
                15451410455351L
        };

        if (pq == null) System.exit(1);

        long p = pq[0];
        long q = pq[1];
        long phi = (pq[0]-1)*(pq[1]-1);
        long d = Fermat.modInverse(e, phi);
        System.out.printf("p = %d, q = %d\n", p, q);
        System.out.printf("φ(n) = (p-1)*(q-1) = %d\n", phi);
        System.out.printf("d*e === 1 mod φ(n) = %d\n\n", d);

        System.out.println("decrypting given values as c^d mod n -> byte array -> Windows-1251: ");
        for (long l : msg) {
            System.out.print(RSA.decrypt(l, d, n));
        }
    }
}