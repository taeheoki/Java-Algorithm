package src.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 1456 - 거의 소수
 */
public class Pro1456 {
    static long A, B;
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        int max = 10000000;

        prime = new boolean[max + 1];
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i <= max; i++) {
            if (prime[i])
                continue;
            for (int j = i * 2; j <= max; j += i)
                prime[j] = true;
        }

        int cnt = 0;
        for (int i = 2; i <= max; i++) {
            if (i >= B)
                break;
            if (prime[i])
                continue;
            for (int j = 2; ; j++) {
                if ((long) Math.pow(i, j) > B)
                    break;
                if ((long) Math.pow(i, j) < A)
                    continue;
                cnt++;
            }
        }

        System.out.println(cnt);
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
