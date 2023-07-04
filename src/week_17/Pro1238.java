package src.week_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 1238 - 파티
 */
public class Pro1238 {
    static int N, M, X;
    static int[][] dist;
    static ArrayList<Edge>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, time));
        }

        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i <= N; i++)
            dijkstra(i);
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X)
                continue;
            ans = Math.max(ans, dist[i][X] + dist[X][i]);
        }
        System.out.println(ans);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Info(start, 0));
        dist[start][start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (info.dist > dist[start][info.idx])
                continue;
            for (Edge e : edges[info.idx]) {
                if (info.dist + e.weight >= dist[start][e.to])
                    continue;
                dist[start][e.to] = info.dist + e.weight;
                pq.add(new Info(e.to, dist[start][e.to]));
            }
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

    private static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
