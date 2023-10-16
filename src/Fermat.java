public class Fermat {
    public static long[] fermatSolve(long n) {
        if (n <= 0) return null;
        if (n % 2 == 0) return new long[] {n/2, 2};

        long a = (long) Math.ceil(Math.sqrt(n));
        System.out.println("initial a = " + a);
        if (a*a == n) return new long[] {a, a};

        long b;
        while (true) {
            long b1 = a * a - n;
            System.out.println("setting b1 = a^2 - n = " + b1);
            b = (long) Math.sqrt(b1);
            if (b*b == b1) {
                System.out.println("b^2 == b1 found, returning {a-b, a+b}");
                break;
            } else {
                a++;
                System.out.println("b^2 != b1... a incremented");
            }
        }

        return new long[] {a-b, a+b};
    }

    private static long x;
    private static long y;
    private static long gcdExtended(long a, long b) {
        if (a == 0) {
            x = 0;
            y = 1;
            return b;
        }

        long gcd = gcdExtended(b % a, a);
        long x1 = x;
        long y1 = y;

        long tmp = b / a;
        x = y1 - tmp * x1;
        y = x1;

        return gcd;
    }

    public static long modInverse(long A, long M) {
        long res = -1;
        long g = gcdExtended(A, M);
        if (g != 1) {
            System.out.println("Inverse doesn't exist");
        } else {
            res = (x % M + M) % M;
        }

        return res;
    }
}