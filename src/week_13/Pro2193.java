package src.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2193 - 이친수
 * 문제 이해: 이진 수 중 특별한 규칙을 갖는 수를 이친수라 한다.
 *          1. 이친수를 0으로 시작하지 않는다.
 *          2. 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
 */
public class Pro2193 {
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        dp = new long[N + 1][2];
        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }
        System.out.println(dp[N][1]);
    }
}
