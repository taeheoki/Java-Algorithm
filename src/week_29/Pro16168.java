package src.week_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 16168 - 퍼레이드
 */
public class Pro16168 {
    static int V, E;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            adj[v1].add(v2);
            adj[v2].add(v1);
        }
        System.out.println(hasEulerianTrail() ? "YES" : "NO");
    }

    private static boolean isConnected() {
        int start = -1;
        for (int i = 0; i < V; i++) {
            if (adj[i].size() == 0) {
                start = -1;
                break;
            }
            start = i;
            break;
        }
        if (start == -1)
            return false; // 모든 정점의 차수가 0이므로 오일러 트레일을 가짐

        boolean[] visited = new boolean[V];
        dfs(start, visited);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(int start, boolean[] visited) {
        visited[start] = true;
        for (int next : adj[start]) {
            if (!visited[next]) {
                dfs(next, visited);
            }
        }
    }

    private static boolean hasEulerianTrail() {
        if (!isConnected())
            return false;

        int oddCount = 0;
        for (int i = 0; i < V; i++) {
            if (adj[i].size() % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount == 0 || oddCount == 2;
    }
}
