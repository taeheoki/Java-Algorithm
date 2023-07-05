package src.week_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2447 - 별찍기 - 10 
 */
public class Pro2447 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static char[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        pro();
    }

    private static void pro() {
        rec_func(0, 0, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j] == '*' ? map[i][j] : ' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void rec_func(int y, int x, int k) {
        if (k == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1)
                        continue;
                    map[i + y][j + x] = '*';
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1)
                        continue;
                    rec_func(y + i * k / 3, x + j * k / 3, k / 3);
                }
            }
        }
    }
}
