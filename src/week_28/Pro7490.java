package src.week_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 7490 - 0 만들기
 */
public class Pro7490 {
    static StringBuilder sb = new StringBuilder();
    static int T, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            pro();
            if (T != 0)
                sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void pro() {
        rec_func(2, "1", 0, 1);
    }

    private static void rec_func(int depth, String sArr, int num, int tmp) {
        if (depth == N + 1) {
            num += tmp;
            if (num == 0)
                sb.append(sArr).append('\n');
            return;
        }
        rec_func(depth + 1, sArr + " " + depth, num, tmp > 0 ? tmp * 10 + depth : tmp * 10 - depth);
        rec_func(depth + 1, sArr + "+" + depth, num + tmp, depth);
        rec_func(depth + 1, sArr + "-" + depth, num + tmp, (-1) * depth);
    }
}
