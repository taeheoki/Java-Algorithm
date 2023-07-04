package src.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 1719 - 택배
 */
public class Pro1719 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[][] dist, map;
    static ArrayList<Edge>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 집하장의 개수
        m = Integer.parseInt(st.nextToken()); // 집하장간 경로의 개수
        dist = new int[n + 1][n + 1];
        map = new int[n + 1][n + 1];
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[v1].add(new Edge(v2, weight));
            edges[v2].add(new Edge(v1, weight));
        }
        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    sb.append("-").append(' ');
                else
                    sb.append(map[j][i]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        Arrays.fill(dist[start], Integer.MAX_VALUE);

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        pq.add(new Info(start, 0));
        dist[start][start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if (dist[start][info.idx] < info.dist)
                continue;
            for (Edge e : edges[info.idx]) {
                if (dist[start][info.idx] + e.weight >= dist[start][e.to])
                    continue;
                dist[start][e.to] = dist[start][info.idx] + e.weight;
                map[start][e.to] = info.idx;
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
