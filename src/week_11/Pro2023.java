package src.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2023 - 신기한 소수
 * 문제 이해:
 */
public class Pro2023 {
    static StringBuilder sb = new StringBuilder();
    static int N, start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        start = (int) Math.pow(10, N - 1) * 2;
        rec_func(0, N);
        System.out.println(sb);
    }

    private static void rec_func(int output, int n) {
        if (n == 0) {
            sb.append(output).append('\n');
        } else {
            for (int i = 0; i < 10; i++) {
                int next = output * 10 + i;
                if (isPrime(next))
                    rec_func(next, n - 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
