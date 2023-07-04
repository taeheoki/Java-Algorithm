package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 15681 - 트리와 쿼리
 * 문제 이해: 방향성 없는 루트 있는 트리가 주어졌을 때, 정점 U를 루트로 하는 서브트리에 속한 정점의 수를 출력한다.
 */
public class Pro15681 {
    static StringBuilder sb = new StringBuilder();
    static int N, R, Q;
    static ArrayList<Integer>[] adj;
    static int[] node_data, q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 트리의 정점의 수
        R = Integer.parseInt(st.nextToken()); // 루트의 번호
        Q = Integer.parseInt(st.nextToken()); // 쿼리의 수
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        // 트리를 만족하는 그래프이기 때문에 간선의 수는 정해져 있다.
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adj[v1 - 1].add(v2 - 1);
            adj[v2 - 1].add(v1 - 1);
        }
        q = new int[Q];
        for (int i = 0; i < Q; i++)
            q[i] = Integer.parseInt(br.readLine());
        pro();
    }

    private static void pro() {
        node_data = new int[N];
        Arrays.fill(node_data, 1);
        dfs(R - 1, -1);
        for (int i = 0; i < Q; i++) {
            sb.append(node_data[q[i] - 1]).append("\n");
        }
        System.out.println(sb);
    }


    private static void dfs(int x, int par) {
        for (int y : adj[x]) {
            if (y == par)
                continue;
            dfs(y, x);
            node_data[x] += node_data[y];
        }
    }
}
