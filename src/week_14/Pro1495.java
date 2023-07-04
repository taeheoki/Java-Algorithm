package src.week_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 1495 - 기타리스트
 */
public class Pro1495 {
    static int N, S, M;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        dp = new int[N + 1][M + 1];
        Arrays.fill(dp[N], -1);
        dp[0][S]++;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j] > 0) {
                    if (j - arr[i] >= 0)
                        dp[i][j - arr[i]] = 1;
                    if (j + arr[i] <= M)
                        dp[i][j + arr[i]] = 1;
                }
            }
        }
        int res = -1;
        for (int j = 0; j <= M; j++) {
            res = Math.max(res, dp[N][j] == 1 ? j : -1);
        }
        System.out.println(res);
    }
}
