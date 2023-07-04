package src.week_23;

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
        System.out.println(nCm(n, m));
    }

    private static BigInteger nCm(int n, int m) {
        BigInteger c = BigInteger.ONE;
        for (int i = 2; i <= m; i++) {
            c = c.multiply(BigInteger.valueOf(i));
        }
        return nPm(n, m).divide(c);
    }

    private static BigInteger nPm(int n, int m) {
        BigInteger p = BigInteger.ONE;
        for (int i = 0; i < m; i++) {
            p = p.multiply(BigInteger.valueOf(n - i));
        }
        return p;
    }

}
