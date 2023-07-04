package src.week_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 15990 - 1, 2, 3 더하기 5
 * 문제 이해: 주어진 숫자를 만들기 위해 1, 2, 3의 수를 이용하는데, 연속해서 값을 만들어선 안된다.
 */
public class Pro15990 {
    public static final int MOD = 1000000009;

    static StringBuilder sb = new StringBuilder();
    static int T;
    static int[] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        arr = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        pro(Arrays.stream(arr).max().getAsInt());
        for (int i = 0; i < T; i++) {
            sb.append((dp[arr[i]][1] + dp[arr[i]][2] + dp[arr[i]][3]) % MOD).append('\n');
        }
        System.out.println(sb);
    }

    private static void pro(int n) {
        dp = new long[n + 1][3 + 1];
        dp[1][1] = 1;
        if (n >= 2) {
            dp[2][2] = 1;
        }
        if (n >= 3) {
            dp[3][1] = 1; // 2, 1
            dp[3][2] = 1; // 1, 2
            dp[3][3] = 1; // 3
        }
        for (int i = 4; i <= n; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }
    }
}
