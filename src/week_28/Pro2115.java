package src.week_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2115 - 갤러리
 */
public class Pro2115 {
    static int M, N, res;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[M][N];
        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }
//        dfs(0, 0, 0);
    }

//    private static void dfs(int r, int c, int cnt) {
//        if (r == N) {
//            res = Math.max(res, cnt);
//            return;
//        }
//        int nr = r;
//        int nc = c + 1;
//        if (nc == M)
//        if (c + 1 == M) {
//            nr += 1;
//            nc = 0;
//        }
//        dfs(nr, nc, cnt);
//        if (map[r][c] == '.') {
//            // 오른쪽 한칸 체크 (상하)
//            if (c + 1 < M && map[r][c + 1] == '.') {
//                if (r - 1 >= 0 && map[r - 1][c] == 'X' && map[r - 1][c + 1] == 'X') {
//                    dfs(nr, nc, cnt + 1);
//                }
//                if (r + 1 < M && map[r + 1][c] == 'X' && map[r - 1][c + 1] == 'X')
//            }
//            // 아래 한칸 체크 (좌우)
//            if (r + 1 < M && map[r + 1][c] == '.') {
//
//            }
//        }
//    }
}
