package src.week_41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

/**
 * BOJ 2828 - 사과 담기 게임
 */
public class BOJ2828 {
    static int N, M, J;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        J = Integer.parseInt(br.readLine());

        int res = 0;
        int min = 1;
        int max = M;
        while (J-- > 0) {
            int pos = Integer.parseInt(br.readLine());
            int diff = 0;
            if (pos < min) {
                diff = min - pos;
                min -= diff;
                max -= diff;
            } else if (pos > max) {
                diff = pos - max;
                min += diff;
                max += diff;
            }
            res += diff;
        }
        System.out.println(res);
    }
}
