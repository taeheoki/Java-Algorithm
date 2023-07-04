package src.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1107 - 리모컨
 */
public class Pro1107 {
    static int N, M, len;
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        int res = Math.abs(N - 100);
        for (int i = 0; i <= 999999; i++) {
            if (!isPossibleNum(i))
                continue;
            if (Math.abs(i - N) + len >= res)
                continue;
            res = Math.abs(i - N) + len;
        }
        System.out.println(res);
    }

    private static boolean isPossibleNum(int num) {
        len = 0;
        if (num == 0) {
            if (broken[0])
                return false;
            len = 1;
        }

        while (num > 0) {
            if (broken[num % 10])
                return false;
            num /= 10;
            len++;
        }
        return true;
    }
}
