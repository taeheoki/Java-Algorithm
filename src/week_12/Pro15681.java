package src.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 15681 - 트리와 쿼리
 */
public class Pro15681 {
    static StringBuilder sb = new StringBuilder();
    static int N, R, Q;
    static int[] dp;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adj[v1].add(v2);
            adj[v2].add(v1);
        }
        pro();
        for (int i = 0; i < Q; i++) {
            int tmp = Integer.parseInt(br.readLine());
            sb.append(dp[tmp]).append('\n');
        }
        System.out.println(sb);
    }

    private static void pro() {
        dp = new int[N + 1];
        Arrays.fill(dp, 1);
        dfs(R, -1);
    }

    private static void dfs(int x, int parent) {
        for (int y : adj[x]) {
            if (y == parent)
                continue;
            dfs(y, x);
            dp[x] += dp[y];
        }
    }
}
