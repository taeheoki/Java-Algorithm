package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 2636 - 치즈
 * 문제 이해: 치즈가 공기중에 놓일 경우 점점 없어지는데, 맨 가쪽부터 매 시간마다 사라진다.
 *          이때 전부 사라지는데 걸리는 시간과, 다 사라지기 직전 치즈의 영역크기를 구하라.
 * 시간 복잡도: map을 두개 만들고(pre, cur), cur 맵의 가쪽 정상부분을 체크한다. 그렇게 시간을 구하고,
 *           치즈가 다 녹을 조건에 pre의 치즈 영역을 구하여, 시간과 치즈 영역에 대한 답을 구한다.
 *           그럴 경우 O(가로 * 세로 * 시간)이 시간 복잡도가 될 것이다.
 *           O(가로 * 세로 * 시간)
 */
public class Pro2636 {
    static int n, m, t;
    static int[][] pre_map, cur_map, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;
    static boolean[][] visit_cheeze;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pre_map = new int[n][m];
        cur_map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                cur_map[i][j] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    private static void pro() {
        visit = new boolean[n][m];
        visit_cheeze = new boolean[n][m];
        int res = 0;
        while (true) {
            // cur_map의 정상 영역을 카운팅 한다.
            int cnt = bfs(0, 0, cur_map[0][0]);

            // pre_map 정상 부분이
            if (cnt == n * m) {
                if (t == 0)
                    break;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++)
                        visit[i][j] = false;
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (pre_map[i][j] == 1) {
                            res += bfs(j, i, pre_map[i][j]);
                        }
                    }
                }
                break;
            }
            // pre_map = cur_map
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    pre_map[i][j] = cur_map[i][j];
                }
            }
            // 맵 수정
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visit_cheeze[i][j]) {
                        cur_map[i][j] = 0;
                    }
                }
            }
            // visit, visit_cheeze 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    visit[i][j] = false;
                    visit_cheeze[i][j] = false;
                }
            }
            t++;
        }
        System.out.println(t);
        System.out.println(res);
    }

    private static int bfs(int start_x, int start_y, int cmp) {
        int cnt = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start_x);
        queue.offer(start_y);
        visit[start_y][start_x] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                    continue;
                if (visit[ny][nx])
                    continue;
                if (cur_map[ny][nx] != cmp) {
                    visit_cheeze[ny][nx] = true;
                    continue;
                }
                queue.offer(nx);
                queue.offer(ny);
                visit[ny][nx] = true;
                cnt++;
            }
        }
        return cnt;
    }
}
