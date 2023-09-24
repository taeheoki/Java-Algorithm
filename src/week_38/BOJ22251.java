package src.week_38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 22251 - 빌런 호석
 */
public class BOJ22251 {
    static int N, K, P, X, res;
    static int[][] display = {{1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 0, 1}, //1
            {0, 1, 1, 1, 1, 1, 0}, //2
            {0, 1, 1, 1, 0, 1, 1}, //3
            {1, 0, 1, 1, 0, 0, 1}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {0, 1, 1, 0, 0, 0, 1}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1}}; //9

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        pro();
    }

    private static void pro() {
        int[] xDigit = numToDigit(X);
        check(0, xDigit);
        System.out.println(res);
    }

    private static void check(int num, int[] xDigit) {
        for (int i = 1; i <= N; i++) {
            if (i == X)
                continue;
            if (isPossible(i, xDigit))
                res++;
        }
    }

    private static boolean isPossible(int target, int[] xDigit) {
        int[] targetDigit = numToDigit(target);

        int diffCount = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 7; j++) {
                if (display[xDigit[i]][j] != display[targetDigit[i]][j]) {
                    diffCount++;
                    if (diffCount > P)
                        return false;
                }
            }
        }
        return true;
    }

    private static int[] numToDigit(int x) {
        int[] result = new int[K];
        for (int i = K - 1; i >= 0; i--) {
            result[i] = x % 10;
            x /= 10;
        }
        return result;
    }
}
