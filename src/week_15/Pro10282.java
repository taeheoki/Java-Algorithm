package src.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 10282 - 해킹
 */
public class Pro10282 {
    static StringBuilder sb = new StringBuilder();
    static int T, n, d, c, a, b, s;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            edges = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());
                edges[b].add(new Edge(a, s));
            }
            dijkstra(c);
            int cnt = 0;
            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    cnt++;
                    res = Math.max(res, dist[i]);
                }
            }
            sb.append(cnt).append(' ').append(res).append('\n');
        }
        System.out.println(sb);
        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.print(usedMemory + " bytes");
    }

    private static void dijkstra(int start) {
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (info.dist > dist[info.idx])
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