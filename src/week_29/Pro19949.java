package src.week_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 19949 - 영재의 시험
 */
public class Pro19949 {
    static int res;
    static int[] arr = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        rec_func(0, 0, 0, 0);
        System.out.println(res);
    }

    private static void rec_func(int depth, int exexNum, int exNum, int score) {
        if (score == 5) {
            res += (int) Math.pow(2, 10 - depth);
            return;
        }
        if (depth == 10)
            return;
        for (int i = 1; i <= 5; i++) {
            if (i == exexNum && i == exNum)
                continue;
            rec_func(depth + 1, exNum, i, i == arr[depth] ? score + 1 : score);
        }
    }
}
