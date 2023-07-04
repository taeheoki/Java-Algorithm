package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * BOJ 2407 - 조합
 */
public class Pro2407 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        BigInteger result = nCm(n, m);
        System.out.println(result);
    }

    private static BigInteger nCm(int n, int m) {
        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;
        for (int i = 0; i < m; i++) {
            numerator = numerator.multiply(BigInteger.valueOf(n - i));
            denominator = denominator.multiply(BigInteger.valueOf(i + 1));
        }
        return numerator.divide(denominator);
    }

}
