package src.week_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 프로그래머스 - 배달
 * 문제 이해: 양방향으로 통행할 수 있는 도로로 연결되어 있는 N개의 마을이 있다.
 *          1번 마을에서 각 마을로 배달을 가려하는데 주어진 K 이하로 배달할 수 있는 도시의 수를 구하라.
 */
public class Pro배달 {
    static ArrayList<Edge>[] edges;
    static int[] dist;

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
    }

    public static int solution(int N, int[][] road, int K) {
        edges = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < road.length; i++) {
            int v1 = road[i][0];
            int v2 = road[i][1];
            int weight = road[i][2];
            edges[v1].add(new Edge(v2, weight));
            edges[v2].add(new Edge(v1, weight));
        }
        dijkstra(1);
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K)
                ans++;
        }
        System.out.println(Arrays.toString(dist));
        return ans;
    }

    private static void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        pq.add(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if (dist[info.idx] < info.dist)
                continue;
            for (Edge e : edges[info.idx]) {
                if (dist[info.idx] + e.weight > dist[e.to])
                    continue;

                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
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
