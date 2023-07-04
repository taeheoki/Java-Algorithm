package src.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 4485 - 녹색 옷 입은 애가 젤다지?
 */
public class Pro4485 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static int[][] map, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        while (true) {
            cnt++;
            N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dist = new int[N][N];
            dijkstra();
            sb.append("Problem ").append(cnt).append(": ").append(dist[N - 1][N - 1]).append('\n');
        }
        System.out.println(sb);
    }

    private static void dijkstra() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        pq.add(new Info(0, 0, 0));
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if (dist[info.y_idx][info.x_idx] < info.dist)
                continue;
            for (int i = 0; i < 4; i++) {
                if (info.x_idx + dx[i] < 0 || info.y_idx + dy[i] < 0 || info.x_idx + dx[i] >= N || info.y_idx + dy[i] >= N)
                    continue;
                if (dist[info.y_idx][info.x_idx] + map[info.y_idx + dy[i]][info.x_idx + dx[i]] >= dist[info.y_idx + dy[i]][info.x_idx + dx[i]])
                    continue;
                dist[info.y_idx + dy[i]][info.x_idx + dx[i]] = dist[info.y_idx][info.x_idx] + map[info.y_idx + dy[i]][info.x_idx + dx[i]];
                pq.add(new Info(info.x_idx + dx[i], info.y_idx + dy[i], dist[info.y_idx + dy[i]][info.x_idx + dx[i]]));
            }
        }
    }

    private static class Info {
        int x_idx;
        int y_idx;
        int dist;

        public Info(int x_idx, int y_idx, int dist) {
            this.x_idx = x_idx;
            this.y_idx = y_idx;
            this.dist = dist;
        }
    }
}
