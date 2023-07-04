package src.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 1238 - 파티
 * 문제 이해: N명의 학생이 마을에 모여서 파티를 벌이려고 하는데,
 *          학생들 중 그 마을에 오고 가는데 가장 많은 시간을 소비하는 학생은 누구인가
 * 시간 복잡도: O(ElogV)
 */
public class Pro1238 {
    static int N, M, X, res;
    static int[][] dist;
    static ArrayList<Edge>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        dist = new int[N + 1][N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, weight));
        }
        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }
        pro();
    }

    private static void pro() {
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            sum += dist[i][X] + dist[X][i];
            res = Math.max(res, sum);
        }
        System.out.println(res);
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
