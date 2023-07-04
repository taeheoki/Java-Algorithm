package src.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * BOJ 1271 - 엄청난 부자2
 */
public class Pro1271 {
    static BigInteger n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = new BigInteger(st.nextToken());
        m = new BigInteger(st.nextToken());
        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));
    }
}
