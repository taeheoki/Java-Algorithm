package src.week_38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1074 - Z
 */
public class BOJ1074 {
    static int N, r, c, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        rec_func((int) Math.pow(2, N), 0, 0);
    }

    private static void rec_func(int size, int y, int x) {
        if (y == r && x == c) {
            System.out.println(res);
            return;
        }
        if (r < y + size && r >= y && c < x + size && c >= x) {
            rec_func(size / 2, y, x);
            rec_func(size / 2, y, x + size / 2);
            rec_func(size / 2, y + size / 2, x);
            rec_func(size / 2, y + size / 2, x + size / 2);
        } else
            res += size * size;
    }
}
