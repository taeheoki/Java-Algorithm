package src.week_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ 19949 - 영재의 시험
 */
public class Pro19949 {
    static int cnt;
    static int[] ans, yj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ans = new int[10];
        yj = new int[10];
        for (int i = 0; i < 10; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }
        rec_func(0, 0);
        System.out.println(cnt);
    }

    private static void rec_func(int depth, int num) {
        if (depth == 10) {
            if (num >= 5) {
                cnt++;
            }
            return;
        }
        for (int i = 1; i <= 5; i++) {
            if (depth >= 2) {
                if (yj[depth - 1] == yj[depth - 2] && yj[depth - 1] == i)
                    continue;
            }
            yj[depth] = i;
            rec_func(depth + 1, ans[depth] == i ? num + 1 : num);
            yj[depth] = 0;
        }
    }
}
