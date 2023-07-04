package src.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 1916 - 최소비용 구하기
 */
public class Pro1916 {
    static int N, M, start, end;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, weight));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);
        System.out.println(dist[end]);
    }

    private static void dijkstra(int start) {
        // 모든 정점까지에 대한 거리를 무한대로 초기화 해주기.
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 최소 힙 생성
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        // 시작점에 대한 정보(Infomation)을 기록에 추가하고, 거리 배열(dist)에 갱신해준다.,
        pq.add(new Info(start, 0));
        dist[start] = 0;

        // 거리 정보들이 모두 소진될 때까지 거리 갱신을 반복한다.
        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if (dist[info.idx] < info.dist)
                continue;
            for (Edge e : edges[info.idx]) {
                if (dist[info.idx] + e.weight >= dist[e.to])
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
