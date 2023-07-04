package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BOJ 2667 - 단지번호붙이기
 * 문제 이해: 주어진 정사각형 안에 지도에서 영역별로 어느정도 차지하고 있지는,
 *          영역의 수와, 그 영역들이 차지하고 있는 자리의 갯수를 오름차순 출력하라.
 * 시간 복잡도: O(N^2)
 */
public class Pro2667 {
    static int N, cnt;
    static String[] map;
    static ArrayList<Integer> arr = new ArrayList<>();
    static boolean[][] visit;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
        }
        pro();
    }

    private static void pro() {
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && map[i].charAt(j) == '1') {
                    int tmp = bfs(i, j);
                    arr.add(tmp);
                }
            }
        }
        Collections.sort(arr);
        sb.append(arr.size()).append("\n");
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int y, int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        queue.offer(y);
        visit[y][x] = true;
        cnt = 1;

        while (!queue.isEmpty()) {
            x = queue.poll();
            y = queue.poll();

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;
                if (visit[ny][nx])
                    continue;
                if (map[ny].charAt(nx) == '0')
                    continue;
                queue.offer(nx);
                queue.offer(ny);
                visit[ny][nx] = true;
                cnt++;
            }
        }
        return cnt;
    }
}
