package src.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2661 - 좋은수열
 */
public class Pro2661 {
    static int N;
    static boolean stop;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rec_func(0, "");
    }

    private static void rec_func(int depth, String num) {
        if (depth == N) {
            System.out.println(num);
            stop = true;
            return;
        }
        for (int i = 1; i <= 3; i++) {
            String tmp = num + i;
            boolean flag = false;
            for (int j = 1; j <= tmp.length() / 2 && !flag; j++) {
                for (int k = 0; k + j <= tmp.length(); k++) {
                    String substring = tmp.substring(k, k + j);
                    if (tmp.indexOf(substring, k + j) == k + j) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag)
                continue;
            if (stop)
                return;
            rec_func(depth + 1, tmp);
        }
    }
}
