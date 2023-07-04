package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 2636 - 치즈
 */
public class Pro2636 {
    static int n, m, t, ans;
    static int[][] map, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit, meltingCheeze;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
    }

    private static void pro() {
        visit = new boolean[n][m];
        meltingCheeze = new boolean[n][m];
        int cnt;
        while ((cnt = bfs()) > 0) {
            t++;
            ans = cnt;
            transfromMap();
        }
        System.out.println(t);
        System.out.println(ans);
    }

    private static void transfromMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = false;
                if (meltingCheeze[i][j])
                    map[i][j] = 0;
            }
        }
    }

    private static int bfs() {
        int cnt = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        que.add(0);
        visit[0][0] = true;

        while (!que.isEmpty()) {
            int y = que.poll();
            int x = que.poll();

            for (int[] dir : dirs) {
                int ny = y + dir[0];
                int nx = x + dir[1];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                    continue;
                if (visit[ny][nx])
                    continue;
                if (map[ny][nx] == 1) {
                    cnt++;
                    visit[ny][nx] = true;
                    meltingCheeze[ny][nx] = true;
                    continue;
                }
                que.add(ny);
                que.add(nx);
                visit[ny][nx] = true;
            }
        }
        return cnt;
    }
}
