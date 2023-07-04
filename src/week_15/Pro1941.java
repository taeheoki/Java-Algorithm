package src.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BOJ 1941 - 소문난 칠공주
 * 문제 이해: 이다솜('S')파와 임도연('Y') 두 파로 나뉘었는데,
 *          칠공주를 형성할 때 가로세로 인접해 있어야하며, 'S'가 4명 이상 포함되어야 한다.
 */
public class Pro1941 {
    static int cnt;
    static int[][] members = new int[5][5];
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;
    static char[][] arr = new char[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        rec_func(0, 0);
        System.out.println(cnt);
    }

    private static void rec_func(int depth, int i) {
        if (depth == 7) {
            visit = new boolean[5][5];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (members[j][k] == 1) {
                        bfs(j, k);
                        return;
                    }
                }
            }
        } else if (i < 25) {
            members[i / 5][i % 5] = 1;
            rec_func(depth + 1, i + 1);
            members[i / 5][i % 5] = 0;
            rec_func(depth, i + 1);
        }
    }

    private static void bfs(int i, int j) {
        int link = 0;
        int s_cnt = 0;

        Queue<Integer> que = new LinkedList<>();
        que.add(i);
        que.add(j);
        visit[i][j] = true;

        while (!que.isEmpty()) {
            int y = que.poll();
            int x = que.poll();

            if (arr[y][x] == 'S')
                s_cnt++;
            link++;
            if (link == 7) {
                if (s_cnt >= 4)
                    cnt++;
                break;
            }

            for (int[] dir : dirs) {
                int ny = y + dir[0];
                int nx = x + dir[1];

                if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5)
                    continue;
                if (visit[ny][nx])
                    continue;
                if (members[ny][nx] == 0)
                    continue;
                que.add(ny);
                que.add(nx);
                visit[ny][nx] = true;
            }
        }
    }
}