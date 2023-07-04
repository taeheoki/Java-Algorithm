package src.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 1939 - 중량제한
 * 문제 이해: N개의 섬들이 있으며, 섬 사이마다 다리가 설치되어 있다.
 * 두 개의 섬에 공장을 세워 두고 물품을 생산하는데, 각각의 다리마다 중량제한이 있기에
 * 물건을 무턱대고 옮길 수 없다.
 * 한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값을 구하라.
 */
public class Pro1939 {
    static int N, M, right, left = Integer.MAX_VALUE, start, end;
    static boolean[] visit;
    static ArrayList<Edge>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges[A].add(new Edge(B, C));
            edges[B].add(new Edge(A, C));
            left = Math.min(left, C);
            right = Math.max(right, C);
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        pro();
    }

    private static void pro() {
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            Arrays.fill(visit, false);
            if (bfs(mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(res);
    }

    private static boolean bfs(int weight) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visit[start] = true;
        while (!que.isEmpty()) {
            int cur = que.poll();
            if (cur == end)
                return true;

            for (Edge e : edges[cur]) {
                int next = e.to;
                if (e.weight < weight)
                    continue;
                if (visit[next])
                    continue;
                que.add(next);
                visit[next] = true;
            }
        }
        return false;
    }

    private static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
