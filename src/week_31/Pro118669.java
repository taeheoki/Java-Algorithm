package src.week_31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 프로그래머스 - 등산코스 정하기
 */
public class Pro118669 {
    static ArrayList<Edge>[] adj;
    static int[] dist, res = new int[2];
    static boolean[] summitList;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}}, new int[]{1, 3}, new int[]{5})));
    }

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        res[1] = Integer.MAX_VALUE;
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        summitList = new boolean[n + 1];
        for (int summit : summits) {
            summitList[summit] = true;
        }

        for (int[] path : paths) {
            int i = path[0];
            int j = path[1];
            int w = path[2];
            adj[i].add(new Edge(j, w));
            adj[j].add(new Edge(i, w));
        }
        dijkstra(n, gates, summits);
        return res;
    }

    private static void dijkstra(int n, int[] gates, int[] summits) {
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        for (int gate : gates) {
            pq.add(new Info(gate, 0));
            dist[gate] = 0;
        }

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            for (Edge e : adj[info.idx]) {
                if (dist[info.idx] >= dist[e.to])
                    continue;
                if (dist[e.to] < e.weight)
                    continue;
                dist[e.to] = Math.max(dist[info.idx], e.weight);
                if (!summitList[e.to])
                    pq.add(new Info(e.to, dist[e.to]));
            }
        }

        Arrays.sort(summits);
        for (int summit : summits) {
            if (res[1] > dist[summit]) {
                res[0] = summit;
                res[1] = dist[summit];
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
