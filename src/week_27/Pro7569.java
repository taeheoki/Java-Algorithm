package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 7569 - 토마토
 */
public class Pro7569 {
    static int M, N, H, res;
    static int[][] dirs = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}, {-1, 0, 0}, {0, -1, 0}, {0, 0, -1}};
    static int[][][] map;
    static Queue<int[]> queue = new LinkedList<>(); // 큐에 토마토 위치를 저장하기 위해 1차원 배열을 사용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k}); // 초기 익은 토마토 위치를 큐에 추가
                    }
                }
            }
        }
        pro();
    }

    private static void pro() {
        while (!queue.isEmpty()) {
            int size = queue.size(); // 현재 큐의 크기를 기록
            boolean hasFreshTomato = false; // 익지 않은 토마토가 있는지 확인하기 위한 플래그
            for (int i = 0; i < size; i++) {
                int[] tomato = queue.poll();
                int z = tomato[0];
                int y = tomato[1];
                int x = tomato[2];

                for (int[] dir : dirs) {
                    int nz = z + dir[0];
                    int ny = y + dir[1];
                    int nx = x + dir[2];
                    if (nz < 0 || ny < 0 || nx < 0 || nz >= H || ny >= N || nx >= M)
                        continue;
                    if (map[nz][ny][nx] == 0) {
                        map[nz][ny][nx] = 1;
                        queue.add(new int[]{nz, ny, nx}); // 익은 토마토 위치를 큐에 추가
                        hasFreshTomato = true; // 익지 않은 토마토가 있음을 표시
                    }
                }
            }
            if (hasFreshTomato) {
                res++;
            }
        }

        if (checkTomato()) {
            System.out.println(res);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean checkTomato() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0)
                        return false;
                }
            }
        }
        return true;
    }
}
