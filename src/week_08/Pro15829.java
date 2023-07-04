package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 15829 - Hasing
 * 문제 이해:
 */
public class Pro15829 {
    static int L;
    static String data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        data = br.readLine();
        pro();
    }

    private static void pro() {
        long res = 0;
        for (int i = 0; i < L; i++) {
            long hash = data.charAt(i) - 'a' + 1;
            for (int j = 0; j < i; j++) {
                hash *= 31;
                hash %= 1234567891;
            }
            res += hash;
        }
        System.out.println(res % 1234567891);
    }
}
