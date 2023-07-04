package src.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 1949 - 우수 마을
 */
public class Pro1949 {
    static int N;
    static int[][] dp;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            dp[i][1] = Integer.parseInt(st.nextToken());
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
    }

    private static void pro() {
        dfs(1, -1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    private static void dfs(int x, int par) {
        for (int y : adj[x]) {
            if (y == par)
                continue;
            dfs(y, x);
            dp[x][0] += Math.max(dp[y][0], dp[y][1]);
            dp[x][1] += dp[y][0];
        }
    }
}
