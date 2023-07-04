package src.week_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 20007 - 떡 돌리기
 */
public class Pro20007 {
    static int N, M, X, Y;
    static int[][] dist;
    static ArrayList<Edge>[] edges;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        dist = new int[N][N];
        edges = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[v1].add(new Edge(v2, weight));
            edges[v2].add(new Edge(v1, weight));
        }
        pro();
    }

    private static void pro() {
        for (int i = 0; i < N; i++) {
            dijkstra(i);
        }

        // Y에서 하루 왕복 X 거리만큼 갈 수 있을 때 이웃집 모두 떡을 돌리는데 걸리는 시간
        visit = new boolean[N];
        dfs(Y);
    }

    private static void dfs(int x) {

    }

    private static void dijkstra(int start) {
        Arrays.fill(dist[start], Integer.MAX_VALUE);

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Info(start, 0));
        dist[start][start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (info.dist > dist[start][info.idx])
                continue;
            for (Edge e : edges[info.idx]) {
                if (dist[start][info.idx] + e.weight >= dist[start][e.to])
                    continue;
                dist[start][e.to] = info.dist + e.weight;
                pq.add(new Info(e.to, dist[start][e.to]));
            }
        }
    }

    private static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static class Info {
        int idx;
        int dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}
