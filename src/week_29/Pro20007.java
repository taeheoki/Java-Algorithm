package src.week_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 20007 - 떡 돌리기
 */
public class Pro20007 {
    static int N, M, X, Y;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // 양방향 매핑
            edges[from].add(new Edge(to, weight));
            edges[to].add(new Edge(from, weight));
        }
        dist = new int[N];
        dijkstra(Y);

        // 답 구하는 연산
        Arrays.sort(dist);
        visit = new boolean[N];
        int cnt = 0;
        int visitCnt = 0;
        while (true) {
            boolean flag = false;
            int helth = X;
            for (int i = 0; i < N; i++) {
                if (i == 0 || visit[i])
                    continue;
                helth -= 2 * dist[i];
                if (helth >= 0) {
                    visit[i] = true;
                    flag = true;
                    visitCnt++;
                } else
                    break;
            }
            cnt++;
            if (visitCnt == N - 1)
                break;
            if (!flag) {
                cnt = -1;
                break;
            }
        }
        System.out.println(cnt);
    }

    private static void dijkstra(int start) {
        // 모든 정점까지에 대한 거리를 무한대로 초기화 해주기.
        for (int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 최소 힙 생성
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        // 시작점에 대한 정보(Infomation)을 기록에 추가하고, 거리 배열(dist)에 갱신해준다.,
        pq.offer(new Info(start, 0));
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
                pq.offer(new Info(e.to, dist[e.to]));
            }
        }
    }

    private static class Edge {
        int from;
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
