package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 16915 - 1, 2, 3 더하기 9
 */
public class Pro16195 {
    public static final int MOD = 1000000009;
    static int T, n, m, max;
    static int[][] dp;
    static ArrayList<int[]> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr.add(new int[]{n, m});
            max = Math.max(max, n);
        }
        pro();

        for (int[] ints : arr) {
            n = ints[0];
            m = ints[1];
            int sum = 0;
            for (int i = 1; i <= m; i++) {
                sum = (sum + dp[n][i]) % MOD;
            }
            System.out.println(sum);
        }
    }

    private static void pro() {
        dp = new int[max + 1][max + 1];
        dp[1][1] = 1;
        if (max >= 2) {
            dp[2][1] = 1;
            dp[2][2] = 1;
        }
        if (max >= 3) {
            dp[3][1] = 1;
            dp[3][2] = 2;
            dp[3][3] = 1;
        }
        for (int i = 4; i <= max; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 1; k <= 3; k++) {
                    dp[i][i - j] = (dp[i][i - j] + dp[i - k][i - (j + 1)]) % MOD;
                }
            }
        }
    }
}
