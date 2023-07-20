package src.week_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 21919 - 소수 최소 공배수
 */
public class Pro21919 {
    static int N;
    static boolean[] primes;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        setPrimes();
        StringTokenizer st = new StringTokenizer(br.readLine());
        visit = new boolean[1000000 + 1];
        long sum = 1;
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (visit[tmp])
                continue;
            if (!primes[tmp])
                sum *= tmp;
            visit[tmp] = true;
        }
        System.out.println(sum == 1 ? -1 : sum);
    }

    private static void setPrimes() {
        primes = new boolean[1000000 + 1];
        primes[0] = true;
        primes[1] = true;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i])
                continue;
            for (int j = i * 2; j < primes.length; j += i) {
                primes[j] = true;
            }
        }

    }
}
