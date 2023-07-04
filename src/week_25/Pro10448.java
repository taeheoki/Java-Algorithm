package src.week_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 10448 - 유레카 이론
 */
public class Pro10448 {
    static StringBuilder sb = new StringBuilder();
    static int testCase, K, res;
    static int[] T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        getTN();
        while (testCase-- > 0) {
            res = 0;
            K = Integer.parseInt(br.readLine());
            rec_func(0, 0);
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    private static void rec_func(int depth, int num) {
        if (num > K)
            return;
        else if (num == K && depth == 3) {
            res = 1;
            return;
        }
        if (depth == 3)
            return;
        for (int i = 1; i < T.length; i++) {
            rec_func(depth + 1, num + T[i]);
            if (res == 1 || num + T[i] > K)
                break;
        }
    }

    private static void getTN() {
        T = new int[46];
        for (int i = 1; i < T.length; i++) {
            T[i] = T[i - 1] + i;
        }
    }
}
