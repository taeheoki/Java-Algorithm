package src.week_12;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 - 카카오 프렌즈 컬러링북
 * 문제 이해: 단순히 bfs를 통해 영역의 갯수와 가장큰 영역의 갯수를 출력하는 문제이다.
 *          격자형 bfs로 시간 복잡도는 O(mn)이 나올것으로 예상된다.
 * 시간 복잡도: O(mn)
 */
public class Pro카카오프렌즈컬러링북 {
    static boolean[][] visit;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[] answer = solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}});
        System.out.println(answer[0] + " " + answer[1]);
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && picture[i][j] != 0) {
                    answer[1] = Math.max(answer[1], bfs(i, j, m, n, picture));
                    answer[0]++;
                }
            }
        }
        return answer;
    }

    private static int bfs(int i, int j, int m, int n, int[][] picture) {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(i);
        queue.offer(j);
        visit[i][j] = true;

        while (!queue.isEmpty()) {
            int y = queue.poll();
            int x = queue.poll();
            cnt++;

            for (int[] dir : dirs) {
                int ny = y + dir[0];
                int nx = x + dir[1];
                if (ny < 0 || nx < 0 || ny >= m || nx >= n)
                    continue;
                if (visit[ny][nx])
                    continue;
                if (picture[ny][nx] == picture[i][j]) {
                    queue.offer(ny);
                    queue.offer(nx);
                    visit[ny][nx] = true;
                }
            }
        }
        return cnt;
    }
}
