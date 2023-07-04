package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 20166 - 문자열 지옥에 빠진 호석
 * 그래프 문제, 백트래킹, 중복제거 Set
 */
public class Pro20166 {
    static int N, M, K;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    static char[][] arr;
    static String[] keys;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        keys = new String[K];
        for (int i = 0; i < K; i++) {
            keys[i] = br.readLine();
            map.put(keys[i], 0);
        }
        pro();

        for (String key : keys) {
            System.out.println(map.get(key));
        }
    }

    private static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(0, i, j, String.valueOf(arr[i][j]));
            }
        }
    }

    private static void dfs(int depth, int y, int x, String str) {
        if (map.containsKey(str))
            map.put(str, map.get(str) + 1);
        if (depth < 5) {
            for (int[] dir : dirs) {
                int ny = y + dir[0];
                int nx = x + dir[1];
                if (ny < 0)
                    ny = N - 1;
                if (nx < 0)
                    nx = M - 1;
                if (ny == N)
                    ny = 0;
                if (nx == M)
                    nx = 0;
                dfs(depth + 1, ny, nx, str + arr[ny][nx]);
            }
        }
    }
}
