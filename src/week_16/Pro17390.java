package src.week_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 17390 - 이건 꼭 풀어야 해!
 */
public class Pro17390 {
    static StringBuilder sb = new StringBuilder();
    static int N, Q;
    static int[] A, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        pro();
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[end] - dp[start - 1]).append('\n');
        }
        System.out.println(sb);
    }

    private static void pro() {
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] +  A[i];
        }
    }
}
