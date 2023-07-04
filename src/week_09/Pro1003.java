package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 1003 - 피보나치 수열
 */
public class Pro1003 {
    static StringBuilder sb = new StringBuilder();
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            fibonacci(n);
        }
        System.out.println(sb);
    }

    private static void fibonacci(int n) {
        int zero = 1;
        int one = 0;
        int zeroOne = zero + one;
        for (int i = 0; i < n; i++) {
            zero = one;
            one = zeroOne;
            zeroOne = zero + one;
        }
        sb.append(zero + " " + one).append('\n');
    }
}
