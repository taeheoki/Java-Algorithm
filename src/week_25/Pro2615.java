package src.week_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro2615 {
    static int[][] map = new int[19][19], dirs = {{1, 0}, {0, 1}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
    }

    private static void pro() {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] == 1 || map[i][j] == 2) {
                    if (whoIsWin(i, j, map[i][j])) {
                        System.out.println(map[i][j]);
                        System.out.println(i + 1 + " " + j + 1);
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static boolean whoIsWin(int y, int x, int pivot) {
        for (int[] dir : dirs) {
            int cnt = 1;
//            while () {
//                int ny = y + dir[0] * cnt;
//                int nx = x + dir[0] * cnt;
//            }
            if (cnt == 5)
                return true;
        }
        return false;
    }
}
