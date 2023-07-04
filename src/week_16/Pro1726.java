package src.week_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ  1726 - 로봇
 * 문제 이해:
 */
public class Pro1726 {
    static int M, N, cnt;
    static Robot startLoc;
    static Robot endLoc;
    static int[][] map, dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visit = new int[M][N][4];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken()) - 1;
        int X = Integer.parseInt(st.nextToken()) - 1;
        int dir = Integer.parseInt(st.nextToken()) - 1;
        startLoc = new Robot(new int[]{Y, X}, dir);
        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken()) - 1;
        X = Integer.parseInt(st.nextToken()) - 1;
        dir = Integer.parseInt(st.nextToken()) - 1;
        endLoc = new Robot(new int[]{Y, X}, dir);
        bfs(startLoc);
        System.out.println(visit[endLoc.location[0]][endLoc.location[1]][endLoc.dir] - 1);
    }

    private static void bfs(Robot startLoc) {
        Queue<Robot> que = new LinkedList<>();
        que.add(startLoc);
        visit[startLoc.location[0]][startLoc.location[1]][startLoc.dir] = 1;

        while (!que.isEmpty()) {
            Robot cur = que.poll();
            int y = cur.location[0];
            int x = cur.location[1];
            if (cur == endLoc) {
                return;
            }

            boolean flag= false;
            for (int i = 1; i <= 3; i++) {
                int ny = y + dirs[cur.dir][0] * i;
                int nx = x + dirs[cur.dir][1] * i;
                if (ny < 0 || nx < 0 || ny >= M || nx >= N)
                    continue;
                if (map[ny][nx] == 1 || flag) {
                    flag = true;
                    continue;
                }
                if (visit[ny][nx][cur.dir] != 0 && visit[ny][nx][cur.dir] <= visit[y][x][cur.dir] + 1)
                    continue;
                que.add(new Robot(new int[]{ny, nx}, cur.dir));
                visit[ny][nx][cur.dir] = visit[y][x][cur.dir] + 1;
            }
            if (cur.dir == 0 || cur.dir == 1) {
                int nextDir = 2;
                if (visit[y][x][nextDir] == 0 || visit[y][x][nextDir] > visit[y][x][cur.dir] + 1) {
                    que.add(new Robot(new int[]{y, x}, nextDir));
                    visit[y][x][nextDir] = visit[y][x][cur.dir] + 1;
                }
                nextDir = 3;
                if (visit[y][x][nextDir] == 0 || visit[y][x][nextDir] > visit[y][x][cur.dir] + 1) {
                    que.add(new Robot(new int[]{y, x}, nextDir));
                    visit[y][x][nextDir] = visit[y][x][cur.dir] + 1;
                }
            } else if (cur.dir == 2 || cur.dir == 3) {
                int nextDir = 0;
                if (visit[y][x][nextDir] == 0 || visit[y][x][nextDir] > visit[y][x][cur.dir] + 1) {
                    que.add(new Robot(new int[]{y, x}, nextDir));
                    visit[y][x][nextDir] = visit[y][x][cur.dir] + 1;
                }
                nextDir = 1;
                if (visit[y][x][nextDir] == 0 || visit[y][x][nextDir] > visit[y][x][cur.dir] + 1) {
                    que.add(new Robot(new int[]{y, x}, nextDir));
                    visit[y][x][nextDir] = visit[y][x][cur.dir] + 1;
                }
            }
        }
    }

    private static class Robot {
        int[] location;
        int dir;

        public Robot(int[] location, int dir) {
            this.location = location;
            this.dir = dir;
        }
    }
}
