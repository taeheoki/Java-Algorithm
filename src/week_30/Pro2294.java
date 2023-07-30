package src.week_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * BOJ 2294 - 동전 2
 */
public class Pro2294 {
    public static final int MAX = Integer.MAX_VALUE - 1;
    static int n, k;
    static int[] dp, arr;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[100000 + 1];
        Arrays.fill(dp, MAX);
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            dp[tmp] = 1;
            for (int j = tmp; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - tmp] + 1);
            }
        }
        System.out.println(dp[k] == MAX ? -1 : dp[k]);
    }
}
