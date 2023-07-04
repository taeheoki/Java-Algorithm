package src.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 11779 - 최소비용 구하기 2
 * 문제 이해: n개의 도시가 있다. 한 도시에서 출발하여 다른 도시에 도착하는 m개의 버스가 있다.
 *          A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화하려 할 때
 *          A번째 도시에서 B번째 도시까지 가는데 드는 최소 비용과 경로를 출력하라.
 *          항상 시작점에서 도착점까지의 경로가 존재한다.
 */
public class Pro11779 {
    static int n, m;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    static ArrayList<Integer>[] dist_city;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        edges = new ArrayList[n + 1];
        dist_city = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
            dist_city[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
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
        System.out.println(dist_city[end].size());
        for (int i = 0; i < dist_city[end].size(); i++) {
            System.out.print(dist_city[end].get(i) + " ");
        }
    }

    private static void dijkstra(int start) {
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        Queue<Info> pq = new LinkedList<>();

        pq.add(new Info(start, 0));
        dist[start] = 0;
        dist_city[start].add(start);

        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if (dist[info.idx] < info.dist)
                continue;
            for (Edge e : edges[info.idx]) {
                if (dist[info.idx] + e.weight >= dist[e.to])
                    continue;
                dist[e.to] = dist[info.idx] + e.weight;
                dist_city[e.to].clear();  // 기존에 저장된 경로 삭제
                dist_city[e.to].addAll(dist_city[info.idx]);  // 이전 도시에서 온 경로 추가
                dist_city[e.to].add(e.to);  // 현재 도시 추가
                pq.offer(new Info(e.to, dist[e.to]));
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
