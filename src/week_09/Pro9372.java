package src.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 9372 - 상근이의 여행
 * 문제 이해: 최대한 적게 비행기를 타고 모든 국가를 여행할 때
 *          몇번 비행기를 타게 되는가?
 * 시간 복자도: T *
 */
public class Pro9372 {
    static StringBuilder sb = new StringBuilder();
    static int T, N, M;
    static int[] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                pq.add(new Edge(v1, v2, 1));
            }
            pro();
        }
        System.out.println(sb);
    }

    private static void pro() {
        // 각 정점이 포함된 그래프가 어디인지 저장
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            // 사이클이 발생하지 않는 경우 그래프에 포함
            Edge e = pq.poll();
            if (find(e.from) != find(e.to)) {
                sum += e.weight;
                union(e.from, e.to);
            }
        }
        sb.append(sum).append('\n');
    }

    // 부모 노드를 찾는 함수
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // 두 부모노드를 합치는 함수
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y)
            parent[x] = y;
        else
            parent[y] = x;
    }

    private static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
