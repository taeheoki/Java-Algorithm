package src.week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 20164 - 홀수 홀릭 호석
 */
public class Pro20164 {
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static String N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        rec_func(N, 0);
        System.out.println(min + " " + max);
    }

    private static void rec_func(String num, int cnt) {
        cnt += getCountOdd(num);
        if (num.length() == 1) {
            max = Math.max(max, cnt);
            min = Math.min(min, cnt);
            return;
        } else if (num.length() == 2) {
            int e1 = Integer.parseInt(num.substring(0, 1));
            int e2 = Integer.parseInt(num.substring(1, 2));
            rec_func(String.valueOf(e1 + e2), cnt);
        } else {
            for (int i = 1; i <= num.length() - 2; i++) {
                for (int j = i + 1; j <= num.length() - 1; j++) {
                    int e1 = Integer.parseInt(num.substring(0, i));
                    int e2 = Integer.parseInt(num.substring(i, j));
                    int e3 = Integer.parseInt(num.substring(j));
                    rec_func(String.valueOf(e1 + e2 + e3), cnt);
                }
            }
        }
    }

    private static int getCountOdd(String num) {
        int cnt = 0;
        for (int i = 0; i < num.length(); i++) {
            int tmp = Integer.parseInt(num.substring(i, i + 1));
            if (tmp % 2 == 1)
                cnt++;
        }
        return cnt;
    }
}
