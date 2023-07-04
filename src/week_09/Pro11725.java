package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * BOJ 11725 - 트리의 부모 찾기
 * Tree 문제
 */
public class Pro11725 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] parent;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            adj[v1].add(v2);
            adj[v2].add(v1);
        }
        pro();
    }

    private static void pro() {
        dfs(0, -1);
        for (int i = 1; i < N; i++) {
            sb.append(parent[i] + 1).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int par) {
        for (int y : adj[x]) {
            if (y == par)
                continue;
            parent[y] = x;
            dfs(y, x);
        }
    }
}
