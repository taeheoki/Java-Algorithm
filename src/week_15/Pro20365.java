package src.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 20365 - 블로그2
 */
public class Pro20365 {
    static int N, r_cnt, b_cnt;
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        r_cnt = getCount('R');
        b_cnt = getCount('B');
        System.out.println(Math.min(r_cnt, b_cnt));
    }

    private static int getCount(char color) {
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            char tmp = str.charAt(i);
            if (tmp == color)
                continue;
            while (tmp != color && i + 1 < N) {
                i++;
                tmp = str.charAt(i);
            }
            cnt++;
        }
        return cnt;
    }
}
