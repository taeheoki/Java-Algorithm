package src.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2023 - 신기한 소수
 */
public class Pro2023 {
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rec_func(0, 0);
        System.out.println(sb);
    }

    private static void rec_func(int depth, int num) {
        if (depth == N) {
            sb.append(num).append('\n');
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (!isPrime(num * 10 + i))
                continue;
            rec_func(depth + 1, num * 10 + i);
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
