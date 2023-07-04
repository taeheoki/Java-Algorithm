package src.week_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 21919 - 소수 최소 공배수
 */
public class Pro21919 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        boolean[] primes = new boolean[1000000 + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < primes.length; i++) {
            if (!primes[i])
                continue;
            for (int j = i * 2; j < primes.length; j += i) {
                primes[j] = false;
            }
        }

        long ans = 1;
        for (int i = 0; i < N; i++) {
            if (primes[arr[i]])
                ans *= arr[i];
        }
        System.out.println(ans == 1 ? -1 : ans);
    }
}
