package src.week_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2229 - 조 짜기
 */
public class Pro2229 {

    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int max = 0;
            int min = 10001;
            for (int j = i; j > 0; j--) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                dp[i] = Math.max(dp[i], max - min + dp[j - 1]);
            }
        }

        System.out.println(dp[N]);
    }
}
