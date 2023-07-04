package src.week_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 17829 - 222-풀링
 */
public class Pro17829 {
    static int N;
    static int[][] map, resizeMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
    }

    private static void pro() {
        int length = N / 2;
        while (length != 1) {
            resizeMap = new int[length][length];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    resizeMap[i][j] = getSecondNum(map, i * 2, j * 2);
                }
            }
            map = resizeMap;
            length /= 2;
        }
        System.out.println(getSecondNum(map, 0, 0));
    }

    private static int getSecondNum(int[][] map, int i, int j) {
        int max = map[i][j];
        int second = Integer.MIN_VALUE;
        for (int a = i; a <= i + 1; a++) {
            for (int b = j; b <= j + 1; b++) {
                if (max <= map[a][b]) {
                    if (a != i || b != j)
                        second = max;
                    max = map[a][b];
                } else if (second < map[a][b]) {
                    second = map[a][b];
                }
            }
        }
        return second;
    }
}
