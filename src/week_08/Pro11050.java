package src.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 11050 - 이항 계수 1
 */
public class Pro11050 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pro();
    }

    private static void pro() {
        System.out.println(factorial(N) / (factorial(K) * factorial(N - K)));
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        else {
            return n * factorial(n - 1);
        }
    }
}
