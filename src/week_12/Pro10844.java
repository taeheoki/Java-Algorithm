package src.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 10844 - 쉬운 계단 수
 * 문제 이해: 45656와 같은 계산수를 만들어 보자.
 *          N이 주어지고, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자.
 */
public class Pro10844 {
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        dp = new long[N + 1][10];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % 1000000000;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1]  % 1000000000;
                } else
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1])  % 1000000000;
            }
        }

        int sum = 0;
        for (int i = 1; i <= 9; i++) {
            sum = (int) ((sum + dp[N][i]) % 1000000000);
        }
        System.out.println(sum);
    }
}
