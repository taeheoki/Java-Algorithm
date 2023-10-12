package src.week_41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 10709 - 기상캐스터
 */
public class BOJ10709 {
    static int H, W;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        init();
        pro();
    }

    private static void pro() {
        for (int i = 0; i < H; i++) {
            for (int j = 1; j < W; j++) {
                if (map[i][j - 1] != -1 && map[i][j] == -1)
                    map[i][j] = map[i][j - 1] + 1;
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                char ch = str.charAt(j);
                if (ch == 'c')
                    map[i][j] = 0;
                else
                    map[i][j] = -1;
            }
        }
    }
}
