package src.week_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 10994 - 별찍기 - 19
 */
public class Pro10994 {
    static StringBuilder sb = new StringBuilder();
    static int N, length;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        length = (N - 1) * 2 * 2 + 1;
        map = new char[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(map[i], ' ');
        }
        rec_func(0, length);

        for (int i = 0; i < length; i++) {
            sb.append(map[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void rec_func(int s, int len) {
        if (s >= len)
            return;

        for (int i = s; i < len; i++) {
            map[s][i] = '*';
            map[i][s] = '*';
            map[len - 1][i] = '*';
            map[i][len - 1] = '*';
        }
        rec_func(s + 2, len - 2);
    }
}
