package src.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 15486 - 퇴사 2
 */
public class Pro15486 {
    static int N;
    static int[] T, P, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        dp = new int[N + 1];
        int pre_max = 0;
        int res = 0;
        for (int i = 1; i <= N; i++) {
            pre_max = Math.max(pre_max, dp[i - 1]);
            if (i + T[i] - 1 <= N)
                dp[i + T[i] - 1] = Math.max(dp[i + T[i] - 1], pre_max + P[i]);
        }
        for (int i = 1; i <= N; i++) {
            res = Math.max(dp[i], res);
        }
        System.out.println(res);
    }
}
