import java.math.BigInteger;
import java.nio.charset.Charset;

public class RSA {
    public static String decrypt(long val, long d, long n) {
        BigInteger value = BigInteger.valueOf(val);
        byte[] bytes = new byte[4];
        value = value.modPow(BigInteger.valueOf(d), BigInteger.valueOf(n));
        System.arraycopy(value.toByteArray(), 1, bytes, 0, value.toByteArray().length - 1);
        return new String(bytes, Charset.forName("Windows-1251"));
    }
}