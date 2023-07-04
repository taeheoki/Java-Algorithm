package src.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 1504 - 특정한 최단 경로
 * 문제 이해: 방향성 없는 그래프가 주어지고, 1번 정점에서 N번 정점으로 최단 거리로 이동하려 한다.
 *          이때 두 가지 조건을 만족하면서 이동해야 하는데, 그것은 임의로 주어진 두 정점은 반드시 통과해야한다는 점이다.
 */
public class Pro1504 {
    static int N, E;
    static long[] dist1, distV1, distV2;
    static ArrayList<Edge>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist1 = new long[N + 1];
        distV1 = new long[N + 1];
        distV2 = new long[N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, weight));
            edges[to].add(new Edge(from, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        dijkstra(1, dist1);
        dijkstra(v1, distV1);
        dijkstra(v2, distV2);
        long ans1 = dist1[v1] + distV1[v2] + distV2[N];
        long ans2 = dist1[v2] + distV2[v1] + distV1[N];
        long ans = Math.min(ans1, ans2);
        if (ans >= Integer.MAX_VALUE)
            ans = -1;
        System.out.println(ans);
    }

    private static long[] dijkstra(int start, long[] dist) {
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.dist));

        pq.add(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if (dist[info.idx] < info.dist)
                continue;
            for (Edge e : edges[info.idx]) {
                if (dist[info.idx] + e.weight >= dist[e.to])
                    continue;
                dist[e.to] = dist[info.idx] + e.weight;
                pq.offer(new Info(e.to, dist[e.to]));
            }
        }
        return dist;
    }

    private static class Edge {
        int to;
        long weight;

        public Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static class Info {
        int idx;
        long dist;

        public Info(int idx, long dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}
