package src.week_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 2194 - 유닛 이동시키기
 */
public class Pro2194 {
    static int N, M, A, B, K;
    static int[] criteriaStart, criteriaEnd;
    static int[][] map, visit, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 맵의 세로 크기
        M = Integer.parseInt(st.nextToken()); // 맵의 가로 크기
        A = Integer.parseInt(st.nextToken()); // 유닛 세로 크기
        B = Integer.parseInt(st.nextToken()); // 유닛 가로 크기
        K = Integer.parseInt(st.nextToken()); // 장애물 개수
        map = new int[N + 1][M + 1];
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
        }
        st = new StringTokenizer(br.readLine());
        criteriaStart = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        st = new StringTokenizer(br.readLine());
        criteriaEnd = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        pro();
    }

    private static void pro() {
        visit = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++)
            Arrays.fill(visit[i], -1);
        bfs();
        System.out.println(visit[criteriaEnd[0]][criteriaEnd[1]]);
    }

    private static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(criteriaStart[0]);
        que.add(criteriaStart[1]);
        visit[criteriaStart[0]][criteriaStart[1]] = 0;

        while (!que.isEmpty()) {
            int y = que.poll();
            int x = que.poll();
            if (y == criteriaEnd[0] && x == criteriaEnd[1])
                return;
            for (int[] dir : dirs) {
                int ny = y + dir[0];
                int nx = x + dir[1];
                if (ny <= 0 || nx <= 0 || ny > N || nx > M)
                    continue;
                if (visit[ny][nx] >= 0)
                    continue;
                if (!isPossible(ny, nx))
                    continue;
                visit[ny][nx] = visit[y][x] + 1;
                que.add(ny);
                que.add(nx);
            }
        }
    }

    private static boolean isPossible(int y, int x) {
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                int ny = y + i;
                int nx = x + j;
                if (ny > N || nx > M)
                    return false;
                if (map[ny][nx] == 1)
                    return false;
            }
        }
        return true;
    }
}
