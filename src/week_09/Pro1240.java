package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 1240 - 노드사이의 거리
 * 문제 이해: 트리가 주어지고, 두 노드 쌍을 입력 받을 때 두 노드 사이의 거리를 출력하라
 * 시간 복잡도:
 */
public class Pro1240 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static boolean[] visit;
    static ArrayList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            adj[v1].add(new Node(v2, weight));
            adj[v2].add(new Node(v1, weight));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            visit = new boolean[N];
            dfs(start, end, 0);
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int end, int sum) {
        visit[x] = true;

        if (x == end)
            sb.append(sum).append("\n");
        for (Node y : adj[x]) {
            if (visit[y.node])
                continue;
            dfs(y.node, end, sum + y.dist);
        }
    }

    private static class Node{
        int node;
        int dist;

        public Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
}
