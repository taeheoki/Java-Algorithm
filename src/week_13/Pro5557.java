package src.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 5557 - 1학년
 */
public class Pro5557 {
    static int N, res;
    static int[] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()) - 1;
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        res = Integer.parseInt(st.nextToken());
        pro();
    }

    private static void pro() {
        dp = new long[N + 1][21];
        dp[1][arr[1]]++;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] > 0) {
                    if (j + arr[i] <= 20)
                        dp[i][j + arr[i]] += dp[i - 1][j];
                    if (j - arr[i] >= 0)
                        dp[i][j - arr[i]] += dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][res]);
    }
}
