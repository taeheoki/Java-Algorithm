package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * BOJ 20165 - 인내의 도미노 장인 호석
 */
public class Pro20165 {
    static int N, M, R, cnt;
    static int[][] map, dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static char[][] ans;
    static Map<String, Integer> dirMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        ans = new char[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                ans[i][j] = 'S';
            }
        }

        dirMap.put("E", 0);
        dirMap.put("W", 1);
        dirMap.put("S", 2);
        dirMap.put("N", 3);

        while (R-- > 0) {
            // 공격
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            String dir = st.nextToken();
            attack(y, x, dirMap.get(dir));

            // 수비
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken()) - 1;
            x = Integer.parseInt(st.nextToken()) - 1;
            ans[y][x] = 'S';
        }

        System.out.println(cnt);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void attack(int y, int x, int dirIdx) {
        if (ans[y][x] == 'F')
            return;
        int offset = map[y][x];
        ans[y][x] = 'F';
        cnt++;
        for (int i = 0; i < offset; i++) {
            int ny = y + i * dirs[dirIdx][0];
            int nx = x + i * dirs[dirIdx][1];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                continue;
            attack(ny, nx, dirIdx);
        }
    }
}
