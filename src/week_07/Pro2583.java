package src.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * BOJ 2583 - 영역 구하기
 * 문제 이해: 모눈종이가 주어졌을 때, 안에 직사가형이 들어가는데, 직사각형으로 나누어지는
 *          영역이 차지하는 구역을 오름차순으로 표현하라
 * 시간 복잡도: O(MNK) 맵을 찍는데, 맵에 사각형이 차지하는 공간을 표시한다.
 */
public class Pro2583 {
    static int M, N, K, cnt;
    static int[][] map, dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (k >= x1 && j >= y1 && k < x2 && j < y2 && map[j][k] == 0)
                        map[j][k] = 1;
                }
            }
        }
        pro();
    }

    private static void pro() {
        visit = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && map[i][j] == 0) {
                    cnt = 0;
                    dfs(j, i);
                    arr.add(cnt);
                }
            }
        }
        Collections.sort(arr);
        System.out.println(arr.size());
        for (int num : arr)
            System.out.print(num + " ");
    }

    private static void dfs(int x, int y) {
        visit[y][x] = true;
        cnt++;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                continue;
            if (visit[ny][nx])
                continue;
            if (map[ny][nx] == 1)
                continue;
            dfs(nx, ny);
        }
    }
}
