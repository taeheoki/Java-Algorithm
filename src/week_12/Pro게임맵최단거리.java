package src.week_12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 - 게임 맵 최단거리
 * 문제 이해:
 */
public class Pro게임맵최단거리 {
    static int n, m;
    static int[][] visit, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }

    public static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visit = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(visit[i], -1);
        bfs(maps);

        return visit[n - 1][m - 1];
    }

    private static void bfs(int[][] maps) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        queue.offer(0);
        visit[0][0] = 1;
        while (!queue.isEmpty()) {
            int y = queue.poll();
            int x = queue.poll();

            for (int[] dir : dirs) {
                int ny = y + dir[0];
                int nx = x + dir[1];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                    continue;
                if (visit[ny][nx] > 0)
                    continue;
                if (maps[ny][nx] == 0)
                    continue;
                queue.offer(ny);
                queue.offer(nx);
                visit[ny][nx] = visit[y][x] + 1;
            }
        }
    }
}
